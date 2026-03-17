n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

# U D L R
DLIST = [[-1, 0], [1, 0], [0, -1], [0, 1]]

class Pair:
    def __init__(self, i, j, dir):
        self.i = i
        self.j = j
        self.dir = dir

    def _out_of_range(self):
        return 0 > self.i or self.i >= n or 0 > self.j or self.j >= n

    def _is_one_block(self):
        return grid[self.i][self.j] == 1
    
    def _is_two_block(self):
        return grid[self.i][self.j] == 2

    def move(self):
        self.i += DLIST[self.dir][0]
        self.j += DLIST[self.dir][1]
        if self._out_of_range():
            return False
        # U(0) -> R(3) / R(3) -> U(0) / D(1) -> L(2) / L(2) -> D(1)
        if self._is_one_block():
            # print("one")
            if self.dir == 0:
                self.dir = 3
            elif self.dir == 1:
                self.dir = 2
            elif self.dir == 2:
                self.dir = 1
            elif self.dir == 3:
                self.dir = 0
        # U(0) <-> L(2) / D(1) <-> R(3)
        elif self._is_two_block():
            # print("two")
            if self.dir == 0:
                self.dir = 2
            elif self.dir == 1:
                self.dir = 3
            elif self.dir == 2:
                self.dir = 0
            elif self.dir == 3:
                self.dir = 1
        return True

    def __str__(self):
        return "(" + str(self.i) + str(self.j) + ") - " + str(self.dir)

commands = []
for i in range(n):
    commands.append((i, 0, 3)) # left
    commands.append((i, n - 1, 2)) # right
    commands.append((0, i, 1)) # up
    commands.append((n - 1, i, 0)) # down

ans = 0

for i, j, dir in commands:
    pair = Pair(i, j, dir)
    time = 1
    while True:
        time += 1
        if not pair.move():
            break
        # print(pair)
    # print()
    ans = max(ans, time)

print(ans)
