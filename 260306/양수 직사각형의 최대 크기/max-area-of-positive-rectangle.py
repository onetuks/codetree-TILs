n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

ans = -1

def all_positive(x1, y1, x2, y2):
    for i in range(x1, x2 + 1):
        for j in range(y1, y2 + 1):
            if grid[i][j] <= 0:
                return False
    return True

def get_size(x1, y1, x2, y2):
    return (x2 + 1 - x1) * (y2 + 1 - y1)

for x1 in range(n):
    for y1 in range(m):
        for x2 in range(x1, n):
            for y2 in range(y1, m):
                if all_positive(x1, y1, x2, y2):
                    ans = max(ans, get_size(x1, y1, x2, y2))

print(ans)
