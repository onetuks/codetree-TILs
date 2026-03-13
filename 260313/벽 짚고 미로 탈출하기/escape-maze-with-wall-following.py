import sys
sys.setrecursionlimit(10 ** 6)

n = int(input())
x, y = map(int, input().split())
x -= 1
y -= 1

grid = [[ch for ch in input()] for _ in range(n)]
dlist = [[0, 1], [1, 0], [0, -1], [-1, 0]]

ans = -1
block = -100

def no_right_block(i, j, curr_dir):
    right_dir = (curr_dir + 1) % 4
    di, dj = i + dlist[right_dir][0], j + dlist[right_dir][1]
    if 0 <= di < n and 0 <= dj < n:
        return grid[di][dj] != '#'
    return False

def out_of_range(i, j):
    return 0 > i or i >= n or 0 > j or j >= n

def no_straight_block(i, j, d):
    di, dj = i + dlist[d][0], j + dlist[d][1]
    if out_of_range(di, dj):
        return True
    return grid[di][dj] != '#'

def dfs(i, j, dir):
    # print(i, j, dir)
    if out_of_range(i, j):
        return 0
    if no_right_block(i, j, dir):
        d = (dir + 1) % 4
        di, dj = i + dlist[d][0], j + dlist[d][1]
        cnt = dfs(di, dj, d)
        if cnt == -1:
            return cnt
        return cnt + 1
    for idx in range(4):
        d = (dir - idx + 4) % 4
        if no_straight_block(i, j, d):
            di, dj = i + dlist[d][0], j + dlist[d][1]
            cnt = dfs(di, dj, d)
            if cnt == -1:
                return cnt
            return cnt + 1
    return -1

ans = dfs(x, y, 0)

print(ans)
