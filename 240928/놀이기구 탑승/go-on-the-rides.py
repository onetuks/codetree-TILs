dlist = [(-1, 0), (1, 0), (0, -1), (0, 1)]

n = 0
students = dict()
matrix = []

def seat(seq):
    loc = [-1, -1]
    max_like_cnt = 0
    max_void_cnt = 0
    for i in range(n):
        for j in range(n):
            if matrix[i][j] != 0:
                continue
            like_cnt = 0
            void_cnt = 0
            for dx, dy in dlist:
                di, dj = i + dx, j + dy
                if di < 0 or di >= n or dj < 0 or dj >= n:
                    continue
                if matrix[di][dj] == 0:
                    void_cnt += 1
                elif matrix[di][dj] in students[seq]:
                    like_cnt += 1
            if like_cnt > max_like_cnt:
                max_like_cnt = like_cnt
                max_void_cnt = void_cnt
                loc = [i, j]
            elif like_cnt == max_like_cnt and void_cnt > max_void_cnt:
                max_void_cnt = void_cnt
                loc = [i, j]

    if -1 in loc:
        for i in range(n):
            for j in range(n):
                if matrix[i][j] == 0:
                    return [i, j]
    
    return loc



def get_cnt(i, j):
    num = matrix[i][j]
    cnt = 0
    for dx, dy in dlist:
        di, dj = i + dx, j + dy
        if 0 <= di < n and 0 <= dj < n and matrix[di][dj] in students[num]:
            cnt += 1
    return cnt


def main():
    global n, students, matrix

    n = int(input())

    sequence = list()
    matrix = [[0 for _ in range(n)] for _ in range(n)]
    
    for _ in range(n * n):
        line = list(map(int, input().split()))
        students[line[0]] = line[1:]
        sequence.append(line[0])

    for seq in sequence:
        x, y = seat(seq)
        matrix[x][y] = seq

    answer = 0
    for i in range(n):
        for j in range(n):
            cnt = get_cnt(i, j)
            answer += int(pow(10, cnt - 1))

    print(answer)

main()