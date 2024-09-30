s, m, e = sorted(list(map(int, input().split())))

for i in range(s, e + 1):
    if i == m:
        continue
    for j in range(1, 10):
        print("%d * %d = %d" %(i, j, i * j))