dlist = [[0, 1], [1, 0], [0, -1], [-1, 0]]

n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
visited = [[False for _ in range(n)] for _ in range(n)]

def is_profit(k, g):
    return k ** 2 + (k + 1) ** 2 <= g * m

def out_of_range(i, j):
    return 0 > i or i >= n or 0 > j or j >= n

def dfs(i, j, k, step):
    if step > k:
        return 0

    cnt = grid[i][j]

    for dx, dy in dlist:
        di, dj = i + dx, j + dy
        if out_of_range(di, dj) or visited[di][dj]:
            continue
        visited[di][dj] = True
        cnt += dfs(di, dj, k, step + 1)
    
    # print(i, j, k, step, cnt)
    return cnt

answer = 0

for i in range(n):
    for j in range(n):
        for k in range(n):
            visited = [[False for _ in range(n)] for _ in range(n)]
            visited[i][j] = True
            g = dfs(i, j, k, 0)
            if is_profit(k, g):
                answer = max(answer, g)

print(answer)
