dlist = [(0, 1), (0, -1), (1, 0), (-1, 0)]

def convert(i, j):
    matrix[i][j] ^= 1
    for dx, dy in dlist:
        di, dj = i + dx, j + dy
        if 0 <= di < n and 0 <= dj < n:
            matrix[di][dj] ^= 1

n = int(input())
matrix = [list(map(int, input().split())) for _ in range(n)]

ans = 0

for i in range(1, n):
    for j in range(n):
        if matrix[i - 1][j] == 0:
            ans += 1
            convert(i, j)

for mat in matrix:
    if 0 in mat:
        ans = -1
        break

print(ans)