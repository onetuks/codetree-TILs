from enum import Enum
from collections import deque


class OrangeType(Enum):
    EMPTY = 0
    NORMAL = 1
    SPOLIED = 2


DP_SPOILED = 0
DP_EMPTY = -1
DP_UNREACHABLE = -2
DP_INIT = 1e9

DLIST = [(0, 1), (0, -1), (1, 0), (-1, 0)]

n, k = map(int, input().split())
q = deque()
matrix = list()
dp = [[DP_INIT for _ in range(n)] for _ in range(n)]

for i in range(n):
    lst = list(map(int, input().split()))
    matrix.append(lst)
    for j, l in enumerate(lst):
        if l == OrangeType.EMPTY.value:
            dp[i][j] = DP_EMPTY
        elif l == OrangeType.SPOLIED.value:
            dp[i][j] = DP_SPOILED
            q.append((i, j))

def reachable(i, j):
    return 0 <= i < n and 0 <= j < n and matrix[i][j] == OrangeType.NORMAL.value

def regulate_dp():
    for i in range(n):
        for j in range(n):
            if dp[i][j] == DP_INIT:
                dp[i][j] = DP_UNREACHABLE

def infect_orange():
    # print_answer()
    while q:
        i, j = q.pop()

        for dx, dy in DLIST:
            di, dj = i + dx, j + dy
            if reachable(di, dj) and dp[di][dj] > dp[i][j] + 1:
                dp[di][dj] = dp[i][j] + 1
                q.append((di, dj))

    regulate_dp()

def print_answer():
    for d in dp:
        print(*d)

infect_orange()
print_answer()
