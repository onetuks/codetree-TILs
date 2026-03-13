n, m, k = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

def get_max_height():
    for i in range(n):
        for j in range(k, k + m):
            if grid[i][j] != 0:
                return i
    return 0

i = get_max_height()

for j in range(k, k + m):
    grid[i][j] = 1

for gr in grid:
    for g in gr:
        print(g, end=" ")
    print() 
