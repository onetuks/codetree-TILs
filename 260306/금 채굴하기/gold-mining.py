n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

ans = 0

def is_profit(k, c):
    return k ** 2 + (k + 1) ** 2 <= c * m

def get_cnt(i, j, k):
    return sum([
        grid[x][y]
        for x in range(n)
        for y in range(n)
        if abs(i - x) + abs(j - y) <= k 
    ])

for i in range(n):
    for j in range(n):
        for k in range(2 * (n - 1) + 1):
            cnt = get_cnt(i, j, k)
            if is_profit(k, cnt):
                ans = max(ans, cnt)

print(ans)