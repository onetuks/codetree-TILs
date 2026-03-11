# Read 4x4 grid
grid = [list(map(int, input().split())) for _ in range(4)]

# Read direction
dir = input()

DIRS = ["L", "D", "R", "U"]

def rotate():
    global grid
    grid = list(map(list, zip(*grid[::-1])))

def drop():
    for i in range(4):
        merged = []
        val = 0
        for j in range(4):
            if grid[i][j] == 0:
                continue
            if val == 0:
                val = grid[i][j]
            elif val == grid[i][j]:
                merged.append(val * 2)
                val = 0
            else:
                merged.append(val)
                val = grid[i][j]
        if val != 0:
            merged.append(val)

        # print(grid[i])

        for j in range(4):
            grid[i][j] = 0
        for j in range(len(merged)):
            grid[i][j] = merged[j]

def tilt():
    dir_num = DIRS.index(dir)
    for _ in range(dir_num):
        rotate()
    drop()
    for _ in range(4 - dir_num):
        rotate()

tilt()

for row in grid:
    for item in row:
        print(item, end = " ")
    print()
