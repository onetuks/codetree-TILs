n = int(input())
a = [list(map(int, input().split())) for _ in range(n)]
dp = [[0 for _ in range(n)] for _ in range(n)]

dp[0][0] = a[0][0]

for i in range(1, n):
    dp[0][i] = max(dp[0][i-1], a[0][i])
    dp[i][0] = max(dp[i-1][0], a[i][0])

for i in range(1, n):
    for j in range(1, n):
        dp[i][j] = max(min(dp[i-1][j], dp[i][j-1]), a[i][j])

print(dp[-1][-1])
