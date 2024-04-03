n = int(input())
w_h = [list(map(int, input().split())) for _ in range(n)]
answer = [1] * n

for i in range(n-1):
    for j in range(i+1, n):
        if w_h[i][0] < w_h[j][0] and w_h[i][1] < w_h[j][1]:
            answer[i] += 1
        elif w_h[i][0] > w_h[j][0] and w_h[i][1] > w_h[j][1]:
            answer[j] += 1
            
for ans in answer:
    print(ans, end=' ')