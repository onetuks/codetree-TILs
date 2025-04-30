class Info:
    def __init__(self, a_cnt, b_cnt, c_cnt):
        self.a_cnt = a_cnt
        self.b_cnt = b_cnt
        self.c_cnt = c_cnt

    def __str__(self):
        return str(self.a_cnt) + " " + str(self.b_cnt) + " " + str(self.c_cnt)

    def print(self):
        print(self.a_cnt, self.b_cnt, self.c_cnt)

n, m, k = map(int, input().split())
grid = [" " * (n + 1)]
for _ in range(n):
    grid.append(" " + input())

def get_cnt(i, j, key):
    if key == "a":
        return psum[i-1][j].a_cnt + psum[i][j-1].a_cnt - psum[i-1][j-1].a_cnt
    elif key == "b":
        return psum[i-1][j].b_cnt + psum[i][j-1].b_cnt - psum[i-1][j-1].b_cnt
    else:
        return psum[i-1][j].c_cnt + psum[i][j-1].c_cnt - psum[i-1][j-1].c_cnt

# Please write your code here.
psum = [[Info(0, 0, 0) for _ in range(n + 1)] for _ in range(n + 1)]
for i in range(1, n+1):
    for j in range(1, n + 1):
        a_cnt, b_cnt, c_cnt = get_cnt(i, j, "a"), get_cnt(i, j, "b"), get_cnt(i, j, "c")
        if grid[i][j] == "a":
            a_cnt += 1
        elif grid[i][j] == "b":
            b_cnt += 1
        else:
            c_cnt += 1
        psum[i][j] = Info(a_cnt, b_cnt, c_cnt)

for _ in range(k):
    i, j, x, y = map(int, input().split())
    a_cnt = psum[x][y].a_cnt - psum[x][j-1].a_cnt - psum[i-1][y].a_cnt + psum[i-1][j-1].a_cnt
    b_cnt = psum[x][y].b_cnt - psum[x][j-1].b_cnt - psum[i-1][y].b_cnt + psum[i-1][j-1].b_cnt
    c_cnt = psum[x][y].c_cnt - psum[x][j-1].c_cnt - psum[i-1][y].c_cnt + psum[i-1][j-1].c_cnt
    print(a_cnt, b_cnt, c_cnt)
