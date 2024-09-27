a, b = map(int, input().split())

direction = 1 if a <= b else -1

for j in range(1, 10):
    for i in range(a, b + direction, direction):
        print("%d * %d = %d" %(i, j, i * j), end="  ")
    print()