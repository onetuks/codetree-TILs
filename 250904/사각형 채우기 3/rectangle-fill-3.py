MOD = 1_000_000_007

n = int(input())

dp = [0 for _ in range(n + 2)]
dp[0] = 1
dp[1] = 2
dp[2] = 7

for i in range(3, n + 1):
    dp[i] = (
        dp[i - 1] * 2 
        + dp[i - 2] * 3 
        + 2 * sum(dp[j] for j in range(i-2))
        ) % MOD

print(dp[n])
