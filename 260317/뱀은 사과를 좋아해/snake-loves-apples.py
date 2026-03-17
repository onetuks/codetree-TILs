from collections import deque

DLIST = [[-1, 0], [1, 0], [0, -1], [0, 1]]
DMAP = {
    "U": 0,
    "D": 1,
    "L": 2,
    "R": 3
}

N, M, K = map(int, input().split())

locations = [tuple(map(int, input().split())) for _ in range(m)]

print(locations) 

class Snake:
    def __init__(self):
        self.q = deque([(1, 1)])

    def move(self, dir, cnt):
        cx, cy = self.q[0]
        for i in range(1, cnt + 1):
            di = cx + DLIST[DMAP[dir]][0] * i
            dj = cy + DLIST[DMAP[dir]][1] * i
            if out_of_range(di, dj):
                return False
            elif overlapped(di, dj):
                return False

            if apple_exists(di, dj):
                self.q.appendleft((di, dj))
                x.remove
            self.q.appendleft((di, dj))
            self.q.pop()
        return True
