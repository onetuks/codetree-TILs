from sortedcontainers import SortedSet

c, n = map(int, input().split())
reds = SortedSet(int(input()) for _ in range(c))
blacks = [tuple(map(int, input().split())) for _ in range(n)]

blacks.sort()

ans = 0
for a, b in blacks:
    idx = reds.bisect_left(a)
    if idx < c and reds[idx] <= b:
        reds.remove(reds[idx])
        ans += 1

print(ans)