from sortedcontainers import SortedSet

n, m = map(int, input().split())
# locs = SortedSet(tuple(map(int, input().split())) for _ in range(n))
locs = SortedSet()
for _ in range(n):
    x, y = map(int, input().split())
    locs.add((x, y))

for _ in range(m):
    k = int(input())

    idx = locs.bisect_left((k, 1))

    if idx >= len(locs):
        print(-1, -1)
        continue

    x, y = locs[idx]
    locs.remove(locs[idx])
    print(x, y)