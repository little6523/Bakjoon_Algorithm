import sys
sys.setrecursionlimit(50000000)

graph = []

def dfs(x, y, w, h):
    if x <= -1 or x >= h or y <= -1 or y >= w:
        return False
    
    if graph[x][y] == 1:
        graph[x][y] = 0
        dfs(x-1,y,w,h)
        dfs(x-1,y-1,w,h)
        dfs(x,y-1,w,h)
        dfs(x+1,y-1,w,h)
        dfs(x+1,y,w,h)
        dfs(x+1,y+1,w,h)
        dfs(x,y+1,w,h)
        dfs(x-1,y+1,w,h)
        return True

    return False

result = []

n = 1

while(True):
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    
    for i in range(h):
        graph.append(list(map(int, input().split())))
        
    count = 0
    for i in range(h):
        for j in range(w):
            if dfs(i, j, w, h) == True:
                count += 1
    graph = []
    
    result.append(count)
    n+=1
    
for i in range(len(result)):
    print(result[i])