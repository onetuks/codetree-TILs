from sortedcontainers import SortedSet

n, m = map(int, input().split())
s = SortedSet()

for _ in range(n):
    s.add(tuple(map(int, input().split())))

for _ in range(m):
    tup = tuple(map(int, input().split()))

    idx = s.bisect_left(tup)

    if idx >= len(s):
        print(-1, -1)
    else:
        print(' '.join(map(str, s[idx])))