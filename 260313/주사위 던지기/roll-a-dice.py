n, m, r, c = map(int, input().split())
directions = list(input().split())
grid = [[0 for _ in range(n)] for _ in range(n)]

class Dice:
    def __init__(self, r, c):
        self.r = r
        self.c = c
        self.top = 1
        self.bottom = 6
        self.left = 4
        self.right = 3
        self.front = 5
        self.back = 2

    def roll_left(self):
        self.c -= 1
        if not self.in_range():
            self.c += 1
            return
        new_top = self.right
        new_left = self.top
        new_right = self.bottom
        new_bottom = self.left
        self.top = new_top
        self.left = new_left
        self.right = new_right
        self.bottom = new_bottom

    def roll_right(self):
        self.c += 1
        if not self.in_range():
            self.c -= 1
            return
        new_right = self.top
        new_top = self.left
        new_left = self.bottom
        new_bottom = self.right
        self.right = new_right
        self.top = new_top
        self.left = new_left
        self.bottom = new_bottom

    def roll_up(self):
        self.r -= 1
        if not self.in_range():
            self.r += 1
            return
        new_front = self.top
        new_top = self.back
        new_back = self.bottom
        new_bottom = self.front
        self.front = new_front
        self.top = new_top
        self.back = new_back
        self.bottom = new_bottom

    def roll_down(self):
        self.r += 1
        if not self.in_range():
            self.r -= 1
            return
        new_back = self.top
        new_top = self.front
        new_front = self.bottom
        new_bottom = self.back
        self.back = new_back
        self.top = new_top
        self.front = new_front
        self.bottom = new_bottom

    def in_range(self):
        return 0 <= self.r < n and 0 <= self.c < n

    def __str__(self):
        return "(" + str(self.r) + "," + str(self.c) + ") : " + str(self.bottom)

dice = Dice(r - 1, c - 1)

for direction in directions:
    grid[dice.r][dice.c] = dice.bottom
    if direction == "L":
        dice.roll_left()
    elif direction == "U":
        dice.roll_up()
    elif direction == "D":
        dice.roll_down()
    else:
        dice.roll_right()

ans = 0
for g in grid:
    ans += sum(g)

print(ans) 

