from heapq import heappush, heappop


dlist = [(-1, 0), (1, 0), (0, -1), (0, 1)]

answer = 1e9
n, k = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]
sr, sc = map(int, input().split())
er, ec = map(int, input().split())

sr -= 1
sc -= 1
er -= 1
ec -= 1

def bfs():
    global answer

    dp = [[1e9 for _ in range(n)] for _ in range(n)]
    dp[sr][sc] = 0
    q = [(0, sr, sc)]

    while q:
        t, i, j = heappop(q)
        
        if i == er and j == ec:
            answer = min(answer, t)
            break
        
        for dx, dy in dlist:
            di, dj = i + dx, j + dy
            if 0 > di and di >= n and 0 > dj and dj >= n: continue
            elif matrix[di][dj] == 1: continue
            elif t+1 >= dp[di][dj]: continue
            dp[di][dj] = t+1
            heappush(q, (dp[di][dj], di, dj))

def dfs(x, y, cnt):
    if cnt == k:
        bfs()
        return
    for i in range(n):
        for j in range(n):
            if i < x: continue
            elif i == x and j <= y: continue
            else:
                matrix[i][j] = 0
                dfs(i, j, cnt+1)
                matrix[i][j] = 1

for i in range(n):
    for j in range(n):
        if matrix[i][j] == 1:
            matrix[i][j] = 0
            dfs(i, j, 1)
            matrix[i][j] = 1
            

print(-1 if answer >= 1e9 else answer)

