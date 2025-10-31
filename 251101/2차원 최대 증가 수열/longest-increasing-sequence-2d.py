'''
dp[i][j] = max(dp[i][j], dp[i-k][j-l] + 1) (0 < k < i, 0 < l < j)
'''
n, m = map(int, input().split())
matrix = [
    [0 for _ in range(m + 1)]
    for _ in range(n + 1)
]
dp = [
    [0 for _ in range(m + 1)]
    for _ in range(n + 1)
]

for i in range(1, n + 1):
    nums = list(map(int, input().split()))
    for j in range(m):
        matrix[i][j + 1] = nums[j]

for i in range(1, n + 1):
    for j in range(1, m + 1):
        for k in range(i):
            for l in range(j):
                if matrix[i][j] > matrix[k][l]:
                    dp[i][j] = max(dp[i][j], dp[k][l] + 1)

print(max(list(max(d) for d in dp)))
