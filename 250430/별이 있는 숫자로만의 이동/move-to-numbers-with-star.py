n, k = map(int, input().split())
psum = [[0 for _ in range(n + 1)] for _ in range(n)]
for i in range(n):
    line = list(map(int, input().split()))
    for j in range(n):
        psum[i][j+1] += psum[i][j] + line[j]

def get_sum(r, c):
    val = 0
    for i in range(k+1):
        if r-i < 0: break
        val += psum[r-i][min(n, c+k-i)] - psum[r-i][max(0, c-k+i-1)]
    for i in range(1, k+1):
        if r+i >= n: break
        val += psum[r+i][min(n, c+k-i)] - psum[r+i][max(0, c-k+i-1)]
    return val

ans = -1e9
for i in range(n):
    for j in range(1, n+1):
        ans = max(ans, get_sum(i, j))

print(ans)