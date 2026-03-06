from collections import deque

DLIST = [[-1, 0], [0, -1], [1, 0], [0, 1]]

n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

ans = 0

def out_of_range(i, j):
    return 0 > i or i >= n or 0 > j or j >= n

def is_profit(k, c):
    return k ** 2 + (k + 1) ** 2 <= c * m

def bfs(i, j, k):
    visited = [[False for _ in range(n)] for _ in range(n)]

    q = deque([(i, j, 0)])
    visited[i][j] = True

    cnt = 0

    while q:
        x, y, s = q.popleft()
        cnt += grid[x][y]

        if s >= k:
            continue

        for dx, dy in DLIST:
            di, dj = x + dx, y + dy
            if out_of_range(di, dj) or visited[di][dj]:
                continue
            visited[di][dj] = True
            q.append((di, dj, s + 1))

    return cnt

# print(bfs(2, 2, 2))

for i in range(n):
    for j in range(n):
        for k in range(n):
            cnt = bfs(i, j, k)
            if is_profit(k, cnt):
                ans = max(ans, cnt)

print(ans)
        