N = int(input())

house = []
dp = []

for i in range(N):
    rgb_cost = list(map(int, input().split()))
    house.append(rgb_cost)
    
dp = [[0] * 3 for _ in range(N)]

for i in range(3):
    dp[0][i] = house[0][i]

for i in range(1, N):
    dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + house[i][0]
    dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + house[i][1]
    dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + house[i][2]

print(min(dp[N-1]))