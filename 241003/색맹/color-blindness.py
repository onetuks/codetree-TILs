dlist = [(0, 1), (0, -1), (1, 0), (-1, 0)]
n, visited, matrix = 0, [], []

def for_normal(i, j):
    for dx, dy in dlist:
        di, dj = i + dx, j + dy
        if 0 <= di < n and 0 <= dj < n and not visited[di][dj] and matrix[di][dj] == matrix[i][j]:
            visited[di][dj] = True
            for_normal(di, dj)


def for_blind(i, j):
    for dx, dy in dlist:
        di, dj = i + dx, j + dy
        if 0 <= di < n and 0 <= dj < n and not visited[di][dj]:
            if matrix[i][j] == 'B' and matrix[i][j] != matrix[di][dj]:
                continue
            elif matrix[i][j] != 'B' and matrix[di][dj] == 'B':
                continue
            visited[di][dj] = True
            for_blind(di, dj)

def main():
    global n, matrix, visited

    n = int(input())

    matrix = [input() for _ in range(n)]

    visited = [[False for _ in range(n)] for _ in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                visited[i][j] = True
                cnt += 1
                for_normal(i, j)

    print(cnt, end=" ")

    visited = [[False for _ in range(n)] for _ in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                visited[i][j] = True
                cnt += 1
                for_blind(i, j)

    print(cnt, end=" ")

main()