n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

DLIST = [[-1, 0], [1, 0], [0, -1], [0, 1]]

def in_range(i, j):
    return 0 <= i < n and 0 <= j < n

def calc(x, y, dir):
    time = 1
    i, j = x, y
    while in_range(i, j):
        if grid[i][j] == 1:
            dir = 3 - dir
        elif grid[i][j] == 2:
            dir = (dir + 2) if dir < 2 else (dir - 2)
        
        i += DLIST[dir][0]
        j += DLIST[dir][1]
        time += 1
    
    return time
        

ans = 0
for i in range(n):
    ans = max(ans, calc(n - 1, i, 0))
    ans = max(ans, calc(0, i, 1))
    ans = max(ans, calc(i, n - 1, 2))
    ans = max(ans, calc(i, 0, 3))

print(ans)
