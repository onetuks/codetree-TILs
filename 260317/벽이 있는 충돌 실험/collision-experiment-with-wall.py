T = int(input())

DMAP = {
    "U": 0,
    "D": 1,
    "R": 2,
    "L": 3
}
DLIST = [[-1, 0], [1, 0], [0, 1], [0, -1]]

def opposite(dir):
    if dir <= 1:
        return 1 - dir
    else:
        return 5 - dir

def in_range(i, j):
    return 0 <= i < n and 0 <= j < n

def move(grid):
    temp = [[[] for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if not grid[i][j]:
                continue
            dlist = DLIST[grid[i][j][0]]
            di, dj = i + dlist[0], j + dlist[1]
            if in_range(di, dj):
                temp[di][dj].append(grid[i][j][0])
            else:
                temp[i][j].append(opposite(grid[i][j][0]))
    for i in range(n):
        for j in range(n):
            if len(temp[i][j]) > 1:
                temp[i][j] = []
    return temp
                

for _ in range(T):
    n, m = map(int, input().split())
    beads = [tuple(input().split()) for _ in range(m)]

    grid = [[[] for _ in range(n)] for _ in range(n)]

    for x, y, d in beads:
        grid[int(x) - 1][int(y) - 1] = [DMAP[d]]
    
    for _ in range(10**4):
        grid = move(grid)
        # for g in grid:
        #     print(g)
        # print()

    ans = 0
    for gr in grid:
        for g in gr:
            if g:
                ans += 1
    print(ans)
