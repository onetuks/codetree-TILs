n, k = map(int, input().split())
commands = [tuple(map(int, input().split())) for _ in range(k)]

seats = [i for i in range(n + 1)]
logs = {i:set([i]) for i in range(1, n + 1)}

for cid in range(3 * k):
    i, j = commands[cid % k]
    logs[seats[i]].add(j)
    logs[seats[j]].add(i)
    seats[i], seats[j] = seats[j], seats[i]

for i in range(1, n + 1):
    print(len(logs[i]))