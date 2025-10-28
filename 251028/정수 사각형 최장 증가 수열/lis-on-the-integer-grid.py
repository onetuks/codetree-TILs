'''
dp[i][j] = 해당 칸을 시작으로 밟을 수 있는 최대 칸 수

1. n * n 완탐
2. 각 칸에서 DFS 시도
3. 구해진 칸에는 DP에 메모이제이션
4. DFS 시도시 DP값이 있으면 따로 DFS 진행하지 않고 DP값 return
'''

INIT = -1
DLIST = [[0, 1], [0, -1], [1, 0], [-1, 0]]

n = int(input())
matrix = [
    list(map(int, input().split()))
    for _ in range(n)
]

dp = [
    [INIT for _ in range(n)]
    for _ in range(n)
]

def in_range(i, j):
    return 0 <= i < n and 0 <= j < n

def dfs(i, j):
    if dp[i][j] != INIT:
        return dp[i][j]

    cnt = 0
    for dx, dy in DLIST:
        di, dj = i + dx, j + dy
        if in_range(di, dj) and matrix[i][j] < matrix[di][dj]:
            cnt = max(cnt, dfs(di, dj))
    
    dp[i][j] = cnt + 1
    return dp[i][j]


for i in range(n):
    for j in range(n):
        if dp[i][j] == INIT:
            dfs(i, j)


# for i in range(n):
#     for j in range(n):
#         print(dp[i][j], end=" ")
#     print()

ans = 0
for i in range(n):
    ans = max(ans, max(dp[i]))

print(ans)
