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

def no_right_block(i, j, d):
    di, dj = i + dlist[d][0], j + dlist[d][1]
    if 0 <= di < n and 0 <= dj < n:
        return grid[di][dj] != '#'
    return False

def dfs(i, j, dir):
    global ans

    print(i, j, dir)

    if 0 > i or i >= n or 0 > j or j >= n:
        print("out of range")
        return 0
    elif grid[i][j] == '#':
        return block
    
    if no_right_block(i, j, dir):
        print("turn clock wise")
        d = (dir + 1) % 4
        return dfs(i + dlist[d][0] , j + dlist[d][1], d)
    for idx in range(4):
        d = (dir - idx + 4) % 4
        if dir == d:
            print("go straight")
        else:
            print("turn counter wise")
        cnt = dfs(i + dlist[d][0], j + dlist[d][1], d)
        if cnt != block:
            return cnt
    return -1

dfs(x, y, 0)

print(ans)
