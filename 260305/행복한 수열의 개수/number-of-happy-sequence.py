n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

answer = 0

for i in range(n):
    r_max_cnt, c_max_cnt = 0, 0
    r_cnt, c_cnt = 0, 0
    r_val, c_val = 0, 0
    for j in range(n):
        if grid[i][j] == r_val:
            r_cnt += 1
        else:
            r_val = grid[i][j]
            r_cnt = 1
        r_max_cnt = max(r_max_cnt, r_cnt)

        if grid[j][i] == c_val:
            c_cnt += 1
        else:
            c_val = grid[j][i]
            c_cnt = 1
        c_max_cnt = max(c_max_cnt, c_cnt)

        
    if r_max_cnt >= m:
        answer += 1
    if c_max_cnt >= m:
        answer += 1


print(answer)