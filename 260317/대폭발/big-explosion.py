dlist = [[-1, 0], [1, 0], [0, -1], [0, 1]]

n, m, r, c = map(int, input().split())

r -= 1
c -= 1

grid = [[False for _ in range(n)] for _ in range(n)]
grid[r][c] = True
temp = [[False for _ in range(n)] for _ in range(n)]

def save_grid():
    global temp
    temp = [[False for _ in range(n)] for _ in range(n)]
    for i in range(n): 
        for j in range(n):
            temp[i][j] = grid[i][j]

def load_grid():
    for i in range(n):
        for j in range(n):
            grid[i][j] = temp[i][j]

def print_grid():
    for g in grid:
        print(g)
    print()

def spread(i, j, t):
    for dx, dy in dlist:
        di = i + dx * (2 ** (t - 1))
        dj = j + dy * (2 ** (t - 1))
        if 0 <= di < n and 0 <= dj < n:
            temp[di][dj] = True

for t in range(1, m + 1):
    save_grid()
    for i in range(n):
        for j in range(n):
            if grid[i][j]:
                spread(i, j, t)
    load_grid()
    # print_grid()
            
ans = 0
for i in range(n):
    ans += sum(grid[i])

print(ans)
