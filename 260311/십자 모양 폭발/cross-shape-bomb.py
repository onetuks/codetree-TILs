n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]
r, c = map(int, input().split())

r -= 1
c -= 1

def explode(r, c):
    power = grid[r][c]
    grid[r][c] = 0
    for i in range(power):
        if c - i >= 0:
            grid[r][c - i] = 0
        if c + i < n:
            grid[r][c + i] = 0
        if r - i >= 0:
            grid[r - i][c] = 0
        if r + i < n:
            grid[r + i][c] = 0
    for col in range(n):
        fall_down(col)

def fall_down(col):
    temp = list()
    for i in reversed(range(n)):
        if grid[i][col] == 0:
            continue
        temp.append(grid[i][col])
        grid[i][col] = 0
    for i in range(len(temp)):
        grid[n - 1 - i][col] = temp[i]

explode(r, c)

for row in grid:
    for item in row:
        print(item, end = " ")
    print()