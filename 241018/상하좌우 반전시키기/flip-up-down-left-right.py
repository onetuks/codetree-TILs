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

for i in range(n):
    for j in range(n):
        if i == 0 and j == 0:
            continue
        zcnt = 0
        for dx, dy in dlist:
            di, dj = i + dx, j + dy
            if 0 <= di < n and 0 <= dj < n and matrix[di][dj] == 0:
                zcnt += 1
        if zcnt >= 2 and matrix[i][j] == 0:
            convert(i, j)
            ans += 1

            # print(i, j)
            # for mat in matrix:
            #     print(mat)
            # print()

for mat in matrix:
    if 0 in mat:
        ans = -1
        break

print(ans)