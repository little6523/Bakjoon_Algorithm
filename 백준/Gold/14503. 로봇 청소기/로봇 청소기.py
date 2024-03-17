n, m = map(int, input().split())
r, c, d = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

dir = [(-1, 0), (0, 1), (1, 0), (0, -1)]

answer = 0
while True:
    if graph[r][c] == 0:
        graph[r][c] = -1
        answer += 1
    
    for i in range(1, 5):
        d -= 1
        if d == -1: d = 3
        
        dr, dc = r + dir[d][0], c + dir[d][1]
        
        if graph[dr][dc] == 0:
            r, c = dr, dc
            break
        
        if i == 4:
            r, c = r - dir[d][0], c - dir[d][1]
            if graph[r][c] == 1: break
            
    if graph[r][c] == 1: break

print(answer)