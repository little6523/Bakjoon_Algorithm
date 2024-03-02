import sys

from collections import deque

m, n = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
dx = [-1,1,0,0]
dy = [0,0,-1,1]

day = 0

def bfs():
    queue = deque()
    
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                queue.append((i, j))
    
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))

bfs()
for row in graph:
    for col in row:
        if col == 0:
            print(-1)
            exit()
    day = max(day, max(row))        

print(day - 1)