DLIST = [[-1, 1], [-1, -1], [1, -1], [1, 1]]

n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

ans = 0

def get_sum(x, y, h, v):
    sumof = 0
    di, dj = x, y
    for d in range(4):
        step = h if d % 2 == 0 else v
        for i in range(step):
            di += DLIST[d][0]
            dj += DLIST[d][1]
            if 0 > di or di >= n or 0 > dj or dj >= n:
                return 0
            sumof += grid[di][dj]
            # if x == 4 and y == 1 and h == 3 and v == 1:
            #     print(di, dj, sumof)
    return sumof

for i in range(n):
    for j in range(n):
        for h in range(1, n):
            for v in range(1, n):
                val = get_sum(i, j, h, v)
                # if i == 4 and j == 1 and h == 3 and v == 1:
                #     print(val)
                ans = max(ans, val)

print(ans)
