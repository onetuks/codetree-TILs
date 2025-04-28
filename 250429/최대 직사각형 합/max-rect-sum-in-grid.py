n = int(input())
matrix = [list(map(int, input().split())) for _ in range(n)]
psum = [[0 for _ in range(n+1)] for _ in range(n + 1)]

def get_sum(x, y, i, j):
    return psum[x][y] - psum[i-1][y] - psum[x][j-1] + psum[i-1][j-1]

for i in range(1, n + 1):
    for j in range(1, n + 1):
        psum[i][j] = psum[i-1][j] + psum[i][j-1] - psum[i-1][j-1] + matrix[i-1][j-1]

# for p in psum:
#     print(p)
        
ans = -1e9
for i in range(1, n+1):
    for j in range(1, n+1):
        for x in range(i, n+1):
            for y in range(j, n+1):
                # print(x, y, i, j, get_sum(x, y, i, j))
                ans = max(ans, get_sum(x, y, i, j))

print(ans)