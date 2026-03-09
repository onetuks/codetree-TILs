n, m, q = map(int, input().split())

# Create 2D array for building state
grid = [list(map(int, input().split())) for _ in range(n)]

# Process wind queries
winds = [tuple(map(int, input().split())) for _ in range(q)]

def rotate(r1, c1, r2, c2):
    temp = grid[r1][c1]
    for i in range(r1, r2):
        grid[i][c1] = grid[i + 1][c1]
    for i in range(c1, c2):
        grid[r2][i] = grid[r2][i + 1]
    for i in range(r2, r1, -1):
        grid[i][c2] = grid[i - 1][c2]
    for i in range(c2, c1, -1):
        grid[r1][i] = grid[r1][i - 1]
    grid[r1][c1 + 1] = temp

def copy(grid):
    return [
        grid[i][:]
        for i in range(n)
    ]

def get_avg(i, j, temp):
    dlist = [[-1, 0], [1, 0], [0, -1], [0, 1]]
    sumof = temp[i][j]
    cnt = 1
    for dx, dy in dlist:
        di, dj = i + dx, j + dy
        if 0 <= di < n and 0 <= dj < m:
            sumof += temp[di][dj]
            cnt += 1
    return sumof // cnt

def effect(temp, r1, c1, r2, c2):
    for i in range(r1, r2 + 1):
        for j in range(c1, c2 + 1):
            grid[i][j] = get_avg(i, j, temp)

# Please write your code here.
for r1, c1, r2, c2 in winds:
    r1 -= 1
    c1 -= 1
    r2 -= 1
    c2 -= 1 

    rotate(r1, c1, r2, c2)
    # temp를 보고 grid에 쓰는 방식
    temp = copy(grid)
    effect(temp, r1, c1, r2, c2)

for row in grid:
    for item in row:
        print(item, end = " ")
    print()
