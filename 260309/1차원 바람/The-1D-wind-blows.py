n, m, q = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]
winds = [(int(r), d) for r, d in [input().split() for _ in range(q)]]

'''
1. 왼쪽 / 오른쪽으로 이동하는 메소드
2. 위쪽 / 아래쪽으로 이동하는 메소드
3. 전파가 가능한지 판단하는 메소드
'''

DIRS = ["L", "R"]

def push_right(lst):
    temp = lst[0]
    for i in range(len(lst) - 1):
        lst[i] = lst[i + 1]
    lst[-1] = temp

def push_left(lst):
    temp = lst[-1]
    for i in reversed(range(1, len(lst))):
        lst[i] = lst[i - 1]
    lst[0] = temp

def effective(origin, other):
    for i in range(len(origin)):
        if origin[i] == other[i]:
            return True
    return False

def effect_up(row, dir):
    if 0 > row or row >= n:
        return
    if not effective(a[row + 1], a[row]):
        return

    if dir == 0:
        push_left(a[row])
    else:
        push_right(a[row])
    
    effect_up(row - 1, (dir + 1) % 2)

def effect_down(row, dir):
    if 0 > row or row >= n:
        return
    if not effective(a[row - 1], a[row]):
        return

    if dir == 0:
        push_left(a[row])
    else:
        push_right(a[row])

    effect_down(row + 1, (dir + 1) % 2)

for row, dir in winds:
    if dir == "L":
        push_left(a[row - 1])
    else:
        push_right(a[row - 1])
    effect_up(row - 2, (DIRS.index(dir) + 1) % 2)
    effect_down(row, (DIRS.index(dir) + 1) % 2)

for line in a:
    for item in line:
        print(item, end = " ")
    print()
