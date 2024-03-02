N, M = map(int, input().split())  # N: 세로 /  M: 가로

ground = [list(map(str, input())) for _ in range(N)]

def M_dfs(x, y):
    if x <= -1 or x >= N or y <= -1 or y >= M:
        return False
    
    if ground[x][y].__eq__('-'):
        ground[x][y] = 'O'
        M_dfs(x, y-1)
        M_dfs(x, y+1)
        return True
    
def N_dfs(x, y):
    if x <= -1 or x >= N or y <= -1 or y >= M:
        return False
    
    if ground[x][y].__eq__('|'):
        ground[x][y] = 'O'
        N_dfs(x-1, y)
        N_dfs(x+1, y)
        return True
    
    return False

result = 0

for i in range(N):
    for j in range(M):
        if M_dfs(i, j) == True:
            result += 1
        if N_dfs(i, j) == True:
            result += 1
            
print(result)