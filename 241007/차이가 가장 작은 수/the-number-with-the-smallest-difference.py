from sortedcontainers import SortedSet

n, m = map(int, input().split())
arr = SortedSet(int(input()) for _ in range(n))

ans = 1e10

for a in arr:
    idx = arr.bisect_right(a + m)

    if idx >= len(arr):
        continue

    if arr[idx] - a >= m:
        ans = min(ans, arr[idx] - a)

print(ans if ans < 1e10 else -1)