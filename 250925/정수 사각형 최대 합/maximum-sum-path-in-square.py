n = int(input())
matrix = [[0 for i in range(n + 1)] for _ in range(n + 1)]
dp = [[0 for i in range(n + 1)] for _ in range(n + 1)]

for i in range(1, n + 1):
    nums = list(map(int, input().split()))
    for j in range(1, n + 1):
        matrix[i][j] = nums[j - 1]

for i in range(1, n + 1):
    for j in range(1, n + 1):
        dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j]

print(dp[n][n])
