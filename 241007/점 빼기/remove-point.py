from sortedcontainers import SortedSet

n, m = map(int, input().split())
locs = SortedSet(tuple(map(int, input().split())) for _ in range(n))

for _ in range(m):
    k = int(input())

    idx = locs.bisect_left((k, 1))

    if idx < 0 or idx >= len(locs):
        print(-1, -1)
        continue

    result = locs[idx]
    locs.remove(result)
    print(' '.join(map(str, result)))