DLIST = [[-1, 0], [1, 0], [0, -1], [0, 1]]

n, r, c = map(int, input().split())
a = [[0] * (n + 1) for _ in range(n + 1)]
visited = [[False for _ in range(n + 1)] for _ in range(n + 1)]

for i in range(1, n + 1):
    row = list(map(int, input().split()))
    for j in range(1, n + 1):
        a[i][j] = row[j - 1]

ans = []

def dfs(i, j):
    for dx, dy in DLIST:
        di, dj = i + dx, j + dy
        if 0 > di or di >= n or 0 > dj or dj >= n:
            continue
        if visited[di][dj]:
            continue
        if a[i][j] < a[di][dj]:
            # print(a[i][j], a[di][dj], "(",i,j,"),", "(",di,dj,")")
            visited[di][dj] = True
            ans.append(a[di][dj])
            dfs(di, dj)
            break

visited[r][c] = True
ans.append(a[r][c])
dfs(r, c)

for num in ans:
    print(num, end=" ")
