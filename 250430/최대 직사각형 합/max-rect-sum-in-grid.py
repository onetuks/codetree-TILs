n = int(input())
arr = [[0 for _ in range(n + 1)]]
for _ in range(n):
    arr.append([0] + list(map(int, input().split())))

def get_sum(x1, y1, x2, y2):
    return psum[x2][y2] - psum[x2][y1-1] - psum[x1-1][y2] + psum[x1-1][y1-1]

def get_max_sum(x1, x2):
    dp = [-1e9] * (n+1)
    for y in range(1, n+1):
        val = get_sum(x1, y, x2, y)
        dp[y] = max(val, dp[y-1] + val)
    return max(dp)

psum = [[0 for _ in range(n+1)] for _ in range(n+1)]
for i in range(1, n+1):
    for j in range(1, n+1):
        psum[i][j] = psum[i-1][j] + psum[i][j-1] - psum[i-1][j-1] + arr[i][j]

ans = -1e9
for i in range(1, n+1):
    for j in range(i, n+1):
        ans = max(ans, get_max_sum(i, j))

print(ans)