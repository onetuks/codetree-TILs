n = int(input())

matrix = [
    [0 for _ in range(n + 1)]
    for _ in range(n + 1)
]

for i in range(1, n + 1):
    nums = list(map(int, input().split()))
    for j in range(n):
        matrix[i][j] = nums[j]

dp = [
    [1e9 for _ in range(n + 1)]
    for _ in range(n + 1)
]
dp[0][n - 1] = 0

for i in range(1, n + 1):
    for j in reversed(range(n)):
        dp[i][j] = min(dp[i - 1][j], dp[i][j + 1]) + matrix[i][j]

print(dp[n][0])
