T = int(input())

answer = []

for i in range(T):
    k = int(input()) # 층
    n = int(input()) # 호

    dp = [[0] * 14 for _ in range(k+1)]
    for j in range(14):
        dp[0][j] = j+1

    sum = 0
    for a in range(1, k+1):
        for b in range(n):
            sum += dp[a-1][b]
            dp[a][b] = sum

        sum = 0

    answer.append(dp[k][n-1])

for i in range(T):
    print(answer[i])