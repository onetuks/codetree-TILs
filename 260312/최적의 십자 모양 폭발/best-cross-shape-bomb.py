n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]
temp = [[0 for _ in range(n)] for _ in range(n)]

def save_grid():
    for i in range(n):
        for j in range(n):
            temp[i][j] = grid[i][j]

def load_grid():
    for i in range(n):
        for j in range(n):
            grid[i][j] = temp[i][j]

def drop():
    for j in range(n):
        temp = []
        for i in range(n):
            if grid[i][j] == 0:
                continue
            temp.append(grid[i][j])
        for i in reversed(range(n)):
            grid[i][j] = temp.pop() if temp else 0

def explode(r, c):
    power = grid[r][c]
    grid[r][c] = 0
    for i in range(power):
        if 0 <= c - i < n:
            grid[r][c - i] = 0
        if 0 <= c + i < n:
            grid[r][c + i] = 0
        if 0 <= r - i < n:
            grid[r - i][c] = 0
        if 0 <= r + i < n:
            grid[r + i][c] = 0
    drop()

def calc():
    dlist = [[-1, 0], [1, 0], [0, -1], [0, 1]]
    cnt = 0
    for i in range(n):
        for j in range(n):
            for dx, dy in dlist:
                di, dj = i + dx, j + dy
                if 0 > di or di >= n or 0 > dj or dj >= n:
                    continue
                if grid[di][dj] == 0:
                    continue
                if grid[i][j] == grid[di][dj]:
                    cnt += 1
    return cnt // 2

ans = 0 
for i in range(n):
    for j in range(n):
        save_grid()
        explode(i, j)
        ans = max(ans, calc())
        # print(ans)
        # for g in grid:
        #     print(g)
        load_grid()

print(ans)

