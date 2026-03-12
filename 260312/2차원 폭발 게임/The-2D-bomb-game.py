n, m, k = map(int, input().split())
numbers_2d = [list(map(int, input().split())) for _ in range(n)]
numbers_1d = [0 for _ in range(n)]

def get_end_idx(start_idx, num):
    for end_idx in range(start_idx + 1, len(numbers_1d)):
        if numbers_1d[end_idx] != num:
            return end_idx - 1
    return len(numbers_1d) - 1

def explode():
    while True:
        exploded = False
        curr_idx = 0

        while curr_idx < len(numbers_1d):
            end_idx = get_end_idx(curr_idx, numbers_1d[curr_idx])

            if end_idx - curr_idx + 1 >= m:
                del numbers_1d[curr_idx:end_idx + 1]
                exploded = True
            else:
                curr_idx = end_idx + 1

        if not exploded:
            break

def rotate():
    global numbers_2d
    numbers_2d = list(map(list, zip(*numbers_2d[::-1])))

def copy_col(col):
    global numbers_1d

    numbers_1d = [
        numbers_2d[row][col]
        for row in range(n)
        if numbers_2d[row][col] != 0
    ]

def copy_result(col):
    for row in reversed(range(n)):
        numbers_2d[row][col] = numbers_1d.pop() if numbers_1d else 0

def simulate():
    for col in range(n):
        copy_col(col)
        explode()
        copy_result(col)

simulate()
for _ in range(k):
    rotate()
    simulate()

ans = sum([
    numbers_2d[i][j] != 0
    for i in range(n)
    for j in range(n) 
])

print(ans)
