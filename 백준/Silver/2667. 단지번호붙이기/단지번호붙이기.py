N = int(input())

graph = []
for i in range(N):
    graph.append(list(map(int, input())))
    
count = 0
apart_num = 0
apart_nums = []

def dfs(x, y):
    if x <= -1 or x >= N or y <= -1 or y >= N:
        return False
    
    global apart_num
    if graph[x][y] == 1:
        graph[x][y] = 0
        apart_num += 1
        dfs(x-1,y)
        dfs(x,y-1)
        dfs(x+1,y)
        dfs(x,y+1)
        return True
    
    return False

for i in range(N):
    for j in range(N):
        if dfs(i, j) == True:
            count += 1
            apart_nums.append(apart_num)
            apart_num = 0
            
print(count)
apart_nums.sort()
for i in range(len(apart_nums)):
    print(apart_nums[i])