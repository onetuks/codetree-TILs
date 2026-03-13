import sys

n = int(input())
x, y = map(int, input().split())
x -= 1
y -= 1
cx, cy, cd = x, y, 0

grid = [[i for i in input()] for _ in range(n)]
dlist = [[0, 1], [1, 0], [0, -1], [-1, 0]]

ans = 0

def in_range(i, j):
    return 0 <= i < n and 0 <= j < n

def wall_exists(i, j):
    return grid[i][j] == '#'

while in_range(cx, cy):
    # print(cx, cy, cd) 
    nx, ny = cx + dlist[cd][0], cy + dlist[cd][1]

    if not in_range(nx, ny):
        ans += 1
        cx, cy = nx, ny
    elif wall_exists(nx, ny):
        cd = (cd + 3) % 4
    else:
        rx, ry = nx + dlist[(cd + 1) % 4][0], ny + dlist[(cd + 1) % 4][1]
        if not wall_exists(rx, ry):
            cx, cy = rx, ry
            cd = (cd + 1) % 4
            ans += 2
        else:
            cx, cy = nx, ny
            ans += 1

    if cx == x and cy == y and cd == 0:
        print(-1)
        sys.exit(0)

print(ans)
