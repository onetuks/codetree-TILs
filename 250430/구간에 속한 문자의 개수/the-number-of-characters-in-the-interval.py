n, m, k = map(int, input().split())
grid = [" " * (n + 1)]
for _ in range(n):
    grid.append(" " + input())

# Please write your code here.
apsum = [[0 for _ in range(n + 1)] for _ in range(n + 1)]
bpsum = [[0 for _ in range(n + 1)] for _ in range(n + 1)]
cpsum = [[0 for _ in range(n + 1)] for _ in range(n + 1)]
for i in range(1, n+1):
    for j in range(1, n + 1):
        a_cnt = apsum[i-1][j] + apsum[i][j-1] - apsum[i-1][j-1]
        b_cnt = bpsum[i-1][j] + bpsum[i][j-1] - bpsum[i-1][j-1]
        c_cnt = cpsum[i-1][j] + cpsum[i][j-1] - cpsum[i-1][j-1]
        if grid[i][j] == "a":
            a_cnt += 1
        elif grid[i][j] == "b":
            b_cnt += 1
        else:
            c_cnt += 1
        apsum[i][j] = a_cnt
        bpsum[i][j] = b_cnt
        cpsum[i][j] = c_cnt

for _ in range(k):
    i, j, x, y = map(int, input().split())
    a_cnt = apsum[x][y] - apsum[x][j-1] - apsum[i-1][y] + apsum[i-1][j-1]
    b_cnt = bpsum[x][y] - bpsum[x][j-1] - bpsum[i-1][y] + bpsum[i-1][j-1]
    c_cnt = cpsum[x][y] - cpsum[x][j-1] - cpsum[i-1][y] + cpsum[i-1][j-1]
    print(a_cnt, b_cnt, c_cnt)
