n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]
r, c, m1, m2, m3, m4, dir = map(int, input().split())

r -= 1
c -= 1

def rotate_counter():
    global r, c, m1, m2, m3, m4
    temp = grid[r][c]
    for i in range(m4):
        grid[r][c] = grid[r - 1][c - 1]
        r -= 1
        c -= 1
    for i in range(m3):
        grid[r][c] = grid[r - 1][c + 1]
        r -= 1
        c += 1
    for i in range(m2):
        grid[r][c] = grid[r + 1][c + 1]
        r += 1
        c += 1
    for i in range(m1):
        grid[r][c] = grid[r + 1][c - 1]
        r += 1
        c -= 1
    grid[r - 1][c + 1] = temp

def rotate_clock():
    global r, c, m1, m2, m3, m4
    temp = grid[r][c]
    for i in range(m1):
        grid[r][c] = grid[r - 1][c + 1]
        r -= 1
        c += 1
    for i in range(m2):
        grid[r][c] = grid[r - 1][c - 1]
        r -= 1
        c -= 1
    for i in range(m3):
        grid[r][c] = grid[r + 1][c - 1]
        r += 1
        c -= 1
    for i in range(m4):
        grid[r][c] = grid[r + 1][c + 1]
        r += 1
        c += 1
    grid[r - 1][c - 1] = temp

if dir == 0: # 반시계
    rotate_counter()
else:
    rotate_clock()

for row in grid:
    for item in row:
        print(item, end = " ")
    print()
