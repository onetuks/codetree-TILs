from sortedcontainers import SortedSet

c, n = map(int, input().split())
reds = SortedSet(int(input()) for _ in range(c))
blacks = [tuple(map(int, input().split())) for _ in range(n)]

blacks.sort(key=lambda x: x[1])

ans = 0

for a, b in blacks:
    idx = reds.bisect_left(a)
    if idx < len(reds) and reds[idx] <= b:
        ans += 1
        reds.pop(idx)

print(ans)