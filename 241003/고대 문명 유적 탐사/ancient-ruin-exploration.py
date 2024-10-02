from collections import deque
from copy import deepcopy

dlist = [(0, 1), (0, -1), (1, 0), (-1, 0)]

def rotate(i, j, r, matrix):
    result = deepcopy(matrix)
    sub = [[result[i + x][j + y] for y in range(3)] for x in range(3)]
    for _ in range(r):
        sub = rotate_sub(sub)
    for x in range(3):
        for y in range(3):
            result[i + x][j + y] = sub[x][y]
    return result


def rotate_sub(sub):
    return list(zip(*sub[::-1]))


def cal_cnt(board):
    result = 0
    visited = [[False] * 5 for _ in range(5)]

    for i in range(5):
        for j in range(5):
            if not visited[i][j]:
                visited[i][j] = True
                dq = deque([(i, j)])
                trace = deque([(i, j)])
                while dq:
                    x, y = dq.popleft()
                    for dx, dy in dlist:
                        di, dj = x + dx, y + dy
                        if 0 <= di < 5 and 0 <= dj < 5 and not visited[di][dj] and board[di][dj] == board[x][y]:
                            visited[di][dj] = True
                            dq.append((di, dj))
                            trace.append((di, dj))
                if len(trace) >= 3:
                    result += len(trace)
                    while trace:
                        x, y = trace.popleft()
                        board[x][y] = 0
    return result


def fill(board):
    for j in range(5):
        for i in reversed(range(5)):
            if board[i][j] == 0:
                board[i][j] = mlist.popleft()
    return board


k, m = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(5)]
mlist = deque(map(int, input().split()))

for _ in range(k):
    max_cnt = 0
    max_matrix = list()
    for r in range(1, 4):
        for i in range(3):
            for j in range(3):
                rotated = rotate(i, j, r, matrix)
                cnt = cal_cnt(rotated)
                if cnt > max_cnt:
                    max_cnt = cnt
                    max_matrix = rotated
    if max_cnt == 0:
        break
    matrix = max_matrix
    while True:
        matrix = fill(matrix)
        cnt = cal_cnt(matrix)
        if cnt == 0:
            break
        max_cnt += cnt

    print(max_cnt, end=" ")