N = int(input())

num = [[0] * N for _ in range(N)]

for i in range(N):
    num[i] = list(map(int, input().split()))

dp = [[0] * N for _ in range(N)]
dp[0][0] = num[0][0]

for i in range(1, N):
    for j in range(i+1):
        if j == 0:
            dp[i][j] = dp[i-1][j] + num[i][j]

        elif j == i:
            dp[i][j] = dp[i-1][j-1] + num[i][j]

        else:
            dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + num[i][j]

print(max(dp[N-1]))