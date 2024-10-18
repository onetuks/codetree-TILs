n = int(input())
matrix = [list(map(int, list(input()))) for _ in range(n)]

ans = 0

def convert(x, y):
    for i in range(x + 1):
        for j in range(y + 1):
            matrix[i][j] ^= 1

for i in reversed(range(n)):
    for j in reversed(range(n)):
        if matrix[i][j] == 1:
            convert(i, j)
            ans += 1

print(ans)