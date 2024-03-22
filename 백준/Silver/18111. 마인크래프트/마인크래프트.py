n, m, b = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
            
ans_time = int(1e9)
ans_height = 0

for i in range(256, -1, -1):
    get_block = 0
    put_block = 0
    for j in range(n):
        for k in range(m):
            if graph[j][k] < i:
                put_block += i - graph[j][k]
                
            else:
                get_block += graph[j][k] - i
                
    if b + get_block - put_block < 0: continue
    
    time = get_block * 2 + put_block
    
    if time < ans_time:
        ans_time = time
        ans_height = i
            
print(ans_time, ans_height)