DLIST = [
    [(0, 0), (-1, 0), (0, 1)], 
    [(0, 0), (0, 1), (1, 0)], 
    [(0, 0), (1, 0), (0, -1)],
    [(0, 0), (0, -1), (-1, 0)], 
    [(0, 0), (0, 1), (0, 2)], 
    [(0, 0), (1, 0), (2, 0)]]

n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

answer = 0

def out_of_range(i, j):
    return 0 > i or i >= n or 0 > j or j >= m

for i in range(n):
    for j in range(m):
        for dlist in DLIST:
            sumof = 0
            for dx, dy in dlist:
                di, dj = i + dx, j + dy
                if out_of_range(di, dj):
                    sumof = 0
                    break
                sumof += grid[di][dj]
            answer = max(answer, sumof)

print(answer)
