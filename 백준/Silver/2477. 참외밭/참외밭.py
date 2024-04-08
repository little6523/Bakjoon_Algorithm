n = int(input())
ground = [list(map(int, input().split())) for _ in range(6)]
w_max, h_max = 0, 0
w_idx, h_idx = 0, 0

for i in range(6):
    cur = ground[i][0]
    if cur == 1 or cur == 2:
        if w_max < ground[i][1]:
            w_max = ground[i][1]
            w_idx = i
        
    elif cur == 3 or cur == 4:
        if h_max < ground[i][1]:
            h_max = ground[i][1]
            h_idx = i

w_cut = abs(ground[(w_idx-1) % 6][1] - ground[(w_idx+1) % 6][1])
h_cut = abs(ground[(h_idx-1) % 6][1] - ground[(h_idx+1) % 6][1])

print(n * (w_max * h_max - w_cut * h_cut))