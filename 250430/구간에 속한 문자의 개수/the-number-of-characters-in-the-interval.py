n, m, k = map(int, input().split())
grid = [" " * (n + 1)]
for _ in range(n):
    grid.append(" " + input())

def get_cnt(i, j, key):
    if key == "a":
        return psum[i-1][j][0] + psum[i][j-1][0] - psum[i-1][j-1][0]
    elif key == "b":
        return psum[i-1][j][1] + psum[i][j-1][1] - psum[i-1][j-1][1]
    else:
        return psum[i-1][j][2] + psum[i][j-1][2] - psum[i-1][j-1][2]

# Please write your code here.
psum = [[[0, 0, 0] for _ in range(n + 1)] for _ in range(n + 1)]
for i in range(1, n+1):
    for j in range(1, n + 1):
        a_cnt, b_cnt, c_cnt = get_cnt(i, j, "a"), get_cnt(i, j, "b"), get_cnt(i, j, "c")
        if grid[i][j] == "a":
            a_cnt += 1
        elif grid[i][j] == "b":
            b_cnt += 1
        else:
            c_cnt += 1
        psum[i][j] = [a_cnt, b_cnt, c_cnt]

for _ in range(k):
    i, j, x, y = map(int, input().split())
    a_cnt = psum[x][y][0] - psum[x][j-1][0] - psum[i-1][y][0] + psum[i-1][j-1][0]
    b_cnt = psum[x][y][1] - psum[x][j-1][1] - psum[i-1][y][1] + psum[i-1][j-1][1]
    c_cnt = psum[x][y][2] - psum[x][j-1][2] - psum[i-1][y][2] + psum[i-1][j-1][2]
    print(a_cnt, b_cnt, c_cnt)
