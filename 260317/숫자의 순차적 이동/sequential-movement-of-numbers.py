n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

DLIST = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1, 1]]

def find_loc(num):
    for i in range(n):
        for j in range(n):
            if grid[i][j] == num:
                return i, j
    return 0, 0

def find_max_loc(i, j):
    val = 0
    ti, tj = i, j
    for dx, dy in DLIST:
        di, dj = i + dx, j + dy
        if 0 <= di < n and 0 <= dj < n:
            if val < grid[di][dj]:
                val = grid[di][dj]
                ti, tj = di, dj
    return ti, tj

def swap(sr, sc, tr, tc):
    temp = grid[sr][sc] 
    grid[sr][sc] = grid[tr][tc]
    grid[tr][tc] = temp

for _ in range(m):
    for num in range(1, n * n + 1):
        r, c = find_loc(num)
        tr, tc = find_max_loc(r, c)
        swap(r, c, tr, tc)

for gr in grid:
    for g in gr:
        print(g, end=" ")
    print()
