n = int(input())

dp = [0 for i in range(n + 1)]
dp[0] = dp[1] = 1

for i in range(2, n+1):
    dp[i] = sum(dp[j] * dp[i - 1 - j] for j in range(i))

print(dp[n])
