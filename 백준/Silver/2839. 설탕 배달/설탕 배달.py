n = int(input())

dp = [0] * 5001
dp[3], dp[5] = 1, 1
for i in range(6, n+1):
    if dp[i-5] == 0 and dp[i-3] == 0: continue
    elif dp[i-5] != 0: dp[i] = dp[i-5] + 1
    elif dp[i-3] != 0: dp[i] = dp[i-3] + 1

if dp[n] == 0: print(-1)    
else: print(dp[n])