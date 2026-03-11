n, m, k = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

def count():
    return sum([
        1
        for i in range(n)
        for j in range(n)
        if grid[i][j] != 0
        else 0
    ])

# while explode():
#     drop()
#     rotate()
#     drop()

print(count())
