import sys
sys.setrecursionlimit(10 ** 6)

n = int(input())
curr_x, curr_y = map(int, input().split())
curr_x -= 1
curr_y -= 1
curr_dir = 0

grid = [[ch for ch in input()] for _ in range(n)]
visited = [[[False for _ in range(4)] for _ in range(n)] for _ in range(n)]
dlist = [[0, 1], [1, 0], [0, -1], [-1, 0]]

ans = 0

def in_range(i, j):
    return 0 <= i < n and 0 <= j < n

def wall_exists(i, j):
    return in_range(i, j) and grid[i][j] == "#"

def simulate():
    global curr_x, curr_y, curr_dir, ans

    if visited[curr_x][curr_y][curr_dir]:
        print(-1)
        sys.exit(0)
    
    visited[curr_x][curr_y][curr_dir] = True

    next_x, next_y = curr_x + dlist[curr_dir][0], curr_y + dlist[curr_dir][1]

    if not in_range(next_x, next_y):
        curr_x, curr_y = next_x, next_y
        ans += 1
        return
    elif wall_exists(next_x, next_y):
        curr_dir = (curr_dir + 3) % 4
    else:
        rx = next_x + dlist[(curr_dir + 1) % 4][0]
        ry = next_y + dlist[(curr_dir + 1) % 4][1]

        if wall_exists(rx, ry):
            curr_x, curr_y = next_x, next_y
            ans += 1
        else:
            curr_x, curr_y = rx, ry
            curr_dir = (curr_dir + 1) % 4
            ans += 2

while in_range(curr_x, curr_y):
    simulate()

print(ans)

