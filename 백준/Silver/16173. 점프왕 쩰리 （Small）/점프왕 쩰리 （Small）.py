N = int(input())

graph = [list(map(int, input().split())) for _ in range(N)]

success = 0

def dfs(x, y):
    if x <= -1 or x >= N or y <= -1 or y >= N:
        return False
    
    if (abs(N-1 - x) + abs(N-1 - y) < graph[x][y]):
        return False
    
    global success
    if graph[x][y] == -1:
        success += 1
    
    elif graph[x][y] > 0:
        go = graph[x][y]
        graph[x][y] = 0
        dfs(x+go, y)
        dfs(x, y+go)
        
dfs(0, 0)

if success > 0:
    print('HaruHaru')
else:
    print('Hing')