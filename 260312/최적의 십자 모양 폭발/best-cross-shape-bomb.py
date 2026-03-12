n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

def explode(r, c):
    exploded = [grid[i][:] for i in range(n)]
    power = exploded[r][c]
    exploded[r][c] = 0
    for i in range(power):
        if 0 <= c - i < n:
            exploded[r][c - i] = 0
        if 0 <= c + i < n:
            exploded[r][c + i] = 0
        if 0 <= r - i < n:
            exploded[r - i][c] = 0
        if 0 <= r + i < n:
            exploded[r + i][c] = 0
    return exploded
    
def drop(exploded):
    dropped = [exploded[i][:] for i in range(n)]
    for j in range(n):
        temp = []
        for i in reversed(range(n)):
            if exploded[i][j] == 0:
                continue
            temp.append(exploded[i][j])
        for i in reversed(range(n)):
            dropped[i][j] = temp.pop() if temp else 0
    return dropped
    
def get_end_idx(arr, idx):
    val = arr[idx]
    for i in range(idx + 1, n):
        if arr[i] == 0:
            return i - 1
        if val != arr[i]:
            return i - 1
    return n - 1

def get_cnt(dropped):
    cnt = 0
    for i in range(n):
        idx = 0
        while idx < n:
            if dropped[i][idx] == 0:
                idx += 1
                continue
            end_idx = get_end_idx(dropped[i], idx)
            if end_idx - idx == 1:
                cnt += 1
            idx = end_idx + 1
    for j in range(n): 
        arr = [dropped[i][j] for i in range(n)]
        idx = 0
        while idx < n:
            if dropped[idx][j] == 0:
                idx += 1
                continue
            end_idx = get_end_idx(arr, idx)
            if end_idx - idx == 1:
                cnt += 1
            idx = end_idx + 1
    return cnt

def simulate(i, j):
    exploded = explode(i, j)
    dropped = drop(exploded)
    cnt = get_cnt(dropped)
    # for g in dropped:
    #     print(g)
    # print(cnt)
    # print()
    return cnt

ans = 0
for i in range(n):
    for j in range(n):
        ans = max(ans, simulate(i, j))

print(ans)
