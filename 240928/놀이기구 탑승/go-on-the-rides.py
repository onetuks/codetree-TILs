dlist = [(0, 1), (0, -1), (1, 0), (-1, 0)]

def seat(num):
    loc = [-1, -1]
    max_like_cnt = 0
    max_void_cnt = 0
    for i in range(n):
        for j in range(n):
            if matrix[i][j] > 0:
                continue
            like_cnt = 0
            void_cnt = 0
            for dx, dy in dlist:
                di, dj = i + dx, j + dy
                if 0 <= di < n and 0 <= dj < n:
                    if matrix[di][dj] == -1:
                        void_cnt += 1
                    elif matrix[di][dj] in students[num]:
                        like_cnt += 1
            if like_cnt > max_like_cnt:
                max_like_cnt = like_cnt
                loc = [i, j]
            if like_cnt == max_like_cnt and void_cnt > max_void_cnt:
                max_void_cnt = void_cnt
                loc = [i, j]
    return loc


def get_like_cnt(i, j):
    cnt = 0
    for dx, dy in dlist:
        di, dj = i + dx, j + dy
        if 0 <= di < n and 0 <= dj < n and matrix[di][dj] in students[matrix[i][j]]:
            cnt += 1
    return cnt


n = int(input())

students = dict()
sequence = list()

for _ in range(n * n):
    line = list(map(int, input().split()))
    students[line[0]] = line[1:]
    sequence.append(line[0])

matrix = [[-1 for _ in range(n)] for _ in range(n)]

for st_num in sequence:
    loc = seat(st_num)
    matrix[loc[0]][loc[1]] = st_num

total_score = 0
for i in range(n):
    for j in range(n):
        like_cnt = get_like_cnt(i, j)
        total_score += pow(10, like_cnt - 1) if like_cnt > 0 else 0

print(total_score)