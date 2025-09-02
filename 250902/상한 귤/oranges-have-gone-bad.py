from collections import deque


n, k = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]

s_pos = [
    (i, j)
    for i in range(n)
    for j in range(n)
    if matrix[i][j] == 2
]

q = deque()
visited = [[False for _ in range(n)] for _ in range(n)]
step = [[0 for _ in range(n)] for _ in range(n)]

def in_range(i, j):
    return 0 <= i < n and 0 <= j < n

def can_go(i, j):
    return in_range(i, j) and not visited[i][j] and matrix[i][j]

def push(i, j, new_step):
    q.append((i, j))
    visited[i][j] = True
    step[i][j] = new_step

def bfs():
    while q:
        i, j = q.popleft()

        for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            di, dj = i + dx, j + dy
            if can_go(di, dj):
                push(di, dj, step[i][j] + 1)


for i, j in s_pos:
    push(i, j, 0)

bfs()

for i in range(n):
    for j in range(n):
        if matrix[i][j] == 0:
            print(-1, end=" ")
        elif matrix[i][j] == 2:
            print(0, end=" ")
        else:
            if not visited[i][j]:
                print(-2, end=" ")
            else:
                print(step[i][j], end=" ")
    print()
