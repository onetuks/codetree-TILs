n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
commands = [int(input()) for _ in range(m)]

def find_row(col):
    for i in range(n):
        if grid[i][col] != 0:
            return i
    return None

def explode(r, c):
    power = grid[r][c]
    grid[r][c] = 0
    for i in range(power):
        if 0 <= r - i < n:
            grid[r - i][c] = 0
        if 0 <= r + i < n:
            grid[r + i][c] = 0
    for j in range(power):
        if 0 <= c - j < n:
            grid[r][c - j] = 0
        if 0 <= c + j < n:
            grid[r][c + j] = 0

def drop():
    for j in range(n):
        temp = []
        for i in reversed(range(n)):
            if grid[i][j] == 0:
                continue
            temp.append(grid[i][j])
        for i in range(n):
            grid[i][j] = 0
        for i in range(len(temp)):
            grid[n - 1 - i][j] = temp[i]

for col in commands:
    col -= 1
    row = find_row(col)
    if row is None:
        continue
    explode(row, col)

    drop()

for gr in grid:
    for g in gr:
        print(g, end = " ")
    print()
