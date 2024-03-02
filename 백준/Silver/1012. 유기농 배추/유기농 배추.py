from collections import deque

T = int(input())

answer = []
graph = [[0] * 50 for _ in range(50)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(n, m, x, y):
    if graph[x][y] == 0:
        return False
    
    queue = deque()
    queue.append((x, y))
    graph[x][y] = 0
    
    while queue:
        x, y = queue.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if graph[nx][ny] == 0:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append((nx, ny))
            
    return True

# m: 가로, n: 세로, k: 배추가 심어져 있는 위치의 개수
for _ in range(T):
    m, n, k = map(int, input().split())
    
    for _ in range(k):
        c, r = map(int, input().split())
        graph[r][c] = 1
        
    count = 0
    for i in range(n):
        for j in range(m):
            if bfs(n, m, i, j) == True:
                count += 1
                
    answer.append(count)
    graph = [[0] * 50 for _ in range(50)]
    
for i in range(len(answer)):
    print(answer[i])