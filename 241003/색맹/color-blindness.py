dlist = [(0, 1), (0, -1), (1, 0), (-1, 0)]
n, visited, matrix = 0, [], []

def dfs(i, j):
    for dx, dy in dlist:
        di, dj = i + dx, j + dy
        if 0 <= di < n and 0 <= dj < n and not visited[di][dj] and matrix[di][dj] == matrix[i][j]:
            visited[di][dj] = True
            dfs(di, dj)

n = int(input())

matrix = [input() for _ in range(n)]

visited = [[False for _ in range(n)] for _ in range(n)]
cnt = 0
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            visited[i][j] = True
            cnt += 1
            dfs(i, j)

print(cnt, end=" ")

for i in range(n):
    matrix[i] = matrix[i].replace('R', 'O').replace('G', 'O')

visited = [[False for _ in range(n)] for _ in range(n)]
cnt = 0
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            visited[i][j] = True
            cnt += 1
            dfs(i, j)

print(cnt, end=" ")