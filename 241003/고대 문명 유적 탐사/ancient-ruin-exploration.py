from collections import deque

nb, ns = 5, 3

class Board:
    def __init__(self):
        self.a = [[0 for _ in range(nb)] for _ in range(nb)]

    def rotate(self, si, sj, cnt):
        result = Board()
        result.a = [row[:] for row in self.a]
        for _ in range(cnt):
            temp = result.a[si + 0][sj + 2]
            result.a[si + 0][sj + 2] = result.a[si + 0][sj + 0]
            result.a[si + 0][sj + 0] = result.a[si + 2][sj + 0]
            result.a[si + 2][sj + 0] = result.a[si + 2][sj + 2]
            result.a[si + 2][sj + 2] = temp
            temp = result.a[si + 1][sj + 2]
            result.a[si + 1][sj + 2] = result.a[si + 0][sj + 1]
            result.a[si + 0][sj + 1] = result.a[si + 1][sj + 0]
            result.a[si + 1][sj + 0] = result.a[si + 2][sj + 1]
            result.a[si + 2][sj + 1] = temp
        return result

    def cal_score(self):
        score = 0
        visited = [[False for _ in range(nb)] for _ in range(nb)]
        dlist = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        for i in range(nb):
            for j in range(nb):
                if not visited[i][j]:
                    visited[i][j] = True
                    q, trace = deque([(i, j)]), deque([(i, j)])
                    while q:
                        x, y = q.popleft()
                        for dx, dy in dlist:
                            di, dj = x + dx, y + dy
                            if 0 <= di < nb and 0 <= dj < nb and self.a[di][dj] == self.a[x][y] and not visited[di][dj]:
                                visited[di][dj] = True
                                q.append((di, dj))
                                trace.append((di, dj))
                    if len(trace) >= 3:
                        score += len(trace)
                        while trace:
                            x, y = trace.popleft()
                            self.a[x][y] = 0
        return score

    def fill(self, que):
        for j in range(nb):
            for i in reversed(range(nb)):
                if self.a[i][j] == 0:
                    self.a[i][j] = que.popleft()

def main():
    k, m = map(int, input().split())
    board = Board()
    for i in range(nb):
        board.a[i] = list(map(int, input().split()))
    mlist = deque()
    for t in list(map(int, input().split())):
        mlist.append(t)

    for _ in range(k):
        max_score = 0
        max_score_board = None
        for cnt in range(1, 4):
            for i in range(3):
                for j in range(3):
                    rotated = board.rotate(i, j, cnt)
                    score = rotated.cal_score()
                    if score > max_score:
                        max_score = score
                        max_score_board = rotated
        if max_score_board is None:
            break
        board = max_score_board
        while True:
            board.fill(mlist)
            new_score = board.cal_score()
            if new_score == 0:
                break
            max_score += new_score
        print(max_score, end=" ")

main()