n, k = map(int, input().split())
psum = [[0 for _ in range(n + 1)] for _ in range(n)]
for i in range(n):
    line = list(map(int, input().split()))
    for j in range(n):
        psum[i][j+1] += psum[i][j] + line[j]

# for p in psum:
#     print(p)

def get_sum(r, c):
    val = 0
    for i in range(k+1):
        if r-i < 0: break
        v = psum[r-i][min(n, c+k-i)] - psum[r-i][max(0, c-k+i-1)]
        # if r == 2 and c == 3:
        #     print(r-i, min(n, c+k-i), max(0, c-k+i-1))
        #     print(v)
        val += v
    for i in range(1, k+1):
        if r+i >= n: break
        v = psum[r+i][min(n, c+k-i)] - psum[r+i][max(0, c-k+i-1)]
        # if r == 3 and c == 2:
        #     print(r+i, min(n, c+k-i), max(0, c-k+i-1))
        #     print(v)
        val += v
    return val

ans = -1e9
for i in range(n):
    for j in range(1, n+1):
        ans = max(ans, get_sum(i, j))

print(ans)