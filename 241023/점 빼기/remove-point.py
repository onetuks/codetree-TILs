from sortedcontainers import SortedSet

n, m = map(int, input().split())
locs = SortedSet(tuple(map(int, input().split())) for _ in range(n))

for _ in range(m):
    k = int(input())
    idx = locs.bisect_left((k, 0))
    if not locs or idx >= len(locs):
        print(-1, -1)
    else:
        loc = locs[idx]
        print(' '.join(map(str, loc)))
        locs.remove(loc)