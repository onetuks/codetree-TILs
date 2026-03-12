n, m, k = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

def count():
    return sum([
        1
        for i in range(n)
        for j in range(n)
        if grid[i][j] != 0
    ])

def rotate():
    global grid
    grid = list(map(list, zip(*grid[::-1])))

def drop():
    for j in range(n):
        temp = []
        for i in reversed(range(n)):
            if grid[i][j] == 0:
                continue
            temp.append(grid[i][j])
        for i in range(n):
            grid[i][j] = 0
        for i in range(len(temp)):
            grid[n - 1 - i][j] = temp[i]

def explode():
    exploded = False
    for j in range(n):
        temp = []
        val, cnt = grid[-1][j], 0
        for i in reversed(range(n)):
            if val == grid[i][j]:
                cnt += 1
                continue
            if cnt < m:
                temp += [val] * cnt
            else:
                exploded = True
            val = grid[i][j]
            cnt = 1
        if 0 < cnt < m:
            temp += [val] * cnt

        for i in range(n):
            grid[i][j] = 0
        for i in range(len(temp)):
            grid[n - 1 - i][j] = temp[i]
    return exploded

curr_time = 0
while explode() or curr_time < k:
    curr_time += 1
    drop()
    # print("after explosion")
    # for g in grid:
    #     print(g)
    # print()
    rotate()
    drop()
    # print("after rotate")
    # for g in grid:
    #     print(g)
    # print()

print(count())
