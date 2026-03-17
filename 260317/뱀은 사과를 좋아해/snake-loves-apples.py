from collections import deque

DLIST = [[-1, 0], [1, 0], [0, -1], [0, 1]]
DMAP = {
    "U": 0,
    "D": 1,
    "L": 2,
    "R": 3
}

n, m, k = map(int, input().split())

locations = [tuple(map(int, input().split())) for _ in range(m)]
commands = [tuple(input().split()) for _ in range(k)]

class Snake:
    def __init__(self):
        self.time = 0
        self.queue = deque([(1, 1)])

    def _out_of_range(self, i, j):
        return 1 > i or i > n or 1 > j or j > n

    def _overlapped(self, i, j):
        for x, y in self.queue:
            if i == x and j == y:
                return True
        return False

    def _apple_exists(self, i, j):
        for x, y in locations:
            if i == x and j == y:
                return True
        return False

    def move(self, dir, cnt):
        cx, cy = self.queue[0]
        for i in range(1, cnt + 1):
            self.time += 1
            di = cx + DLIST[DMAP[dir]][0] * i
            dj = cy + DLIST[DMAP[dir]][1] * i
            if self._out_of_range(di, dj):
                return False
            elif self._overlapped(di, dj):
                return False

            if self._apple_exists(di, dj):
                self.queue.appendleft((di, dj))
                locations.remove((di, dj))
            else:
                self.queue.appendleft((di, dj))
                self.queue.pop()
        return True

snake = Snake()
for dir, cnt in commands:
    cnt = int(cnt)
    result = snake.move(dir, cnt)
    if not result:
        break

print(snake.time)
