from sortedcontainers import SortedSet

n, m = map(int, input().split())
arr = SortedSet(int(input()) for _ in range(n))

ans = 1e10

for a in arr:
    idx = arr.bisect_right(a + m - 1)

    if not arr or idx >= n or idx < 0:
        continue

    if arr[idx] - a >= m:
        ans = min(ans, arr[idx] - a)

print(ans)