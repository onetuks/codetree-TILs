n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

def draw(x1, y1, x2, y2, board):
    for i in range(x1, x2 + 1):
        for j in range(y1, y2 + 1):
            board[i][j] += 1

def check(board):
    for i in range(n):
        for j in range(n):
            if board[i][j] >= 2:
                return True
    return False

def overlapped(x1, y1, x2, y2, x3, y3, x4, y4):
    board = [[0 for _ in range(n)] for _ in range(n)]
    draw(x1, y1, x2, y2, board)
    draw(x3, y3, x4, y4, board)
    return check(board)

def rect_sum(x1, y1, x2, y2):
    sumof = 0
    for i in range(x1, x2 + 1):
        for j in range(y1, y2 + 1):
            sumof += grid[i][j]
    return sumof

def find_max_sum_rect(x1, y1, x2, y2):
    max_sum = -1e9
    for i in range(n):
        for j in range(n):
            for k in range(i, n):
                for l in range(j, n):
                    if overlapped(x1, y1, x2, y2, i, j, k, l):
                        continue
                    max_sum = max(
                        max_sum,
                        rect_sum(x1, y1, x2, y2) + 
                        rect_sum(i, j, k, l)
                    )
    return max_sum

def find_max_sum():
    max_sum = -1e9

    for i in range(n):
        for j in range(n):
            for k in range(i, n):
                for l in range(j, n):
                    max_sum = max(max_sum, find_max_sum_rect(i, j, k, l))
    
    return max_sum


print(find_max_sum())
