from sortedcontainers import SortedSet

n, m = map(int, input().split())
locs = SortedSet(tuple(map(int, input().split())) for _ in range(n))

for _ in range(m):
    k = int(input())

    idx = locs.bisect_left((k, 1))

    if idx >= len(locs):
        print(-1, -1)
        continue

    x, y = locs[idx]
    locs.remove(locs[idx])
    print(x, y)