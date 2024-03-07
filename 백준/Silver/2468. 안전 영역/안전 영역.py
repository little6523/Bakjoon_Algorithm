import sys
sys.setrecursionlimit(10**6)

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

def dfs(x, y, h):    
    if x < 0 or x >= n or y < 0 or y >= n:
        return False
    if graph[x][y] <= h:
        return False
    if graph[x][y] > h:
        graph[x][y] = 0
    
    dfs(x-1, y, h)
    dfs(x, y+1, h)
    dfs(x+1, y, h)
    dfs(x, y-1, h)
    
    return True

max_h = 0
for i in range(n):
    for j in range(n):
        if max_h < graph[i][j]:
            max_h = graph[i][j]
from copy import deepcopy
answer = []
new_graph = deepcopy(graph)
for h in range(max_h):
    count = 0
    for i in range(n):
        for j in range(n):
            if dfs(i, j, h) == True:
                count += 1
                
    answer.append(count)
    graph = deepcopy(new_graph)
                
print(max(answer))