from sortedcontainers import SortedSet

n, m = map(int, input().split())
arr = SortedSet(int(input()) for _ in range(n))

ans = 1e10

for a in arr:
    idx = arr.bisect_right(a + m)

    if idx >= len(arr) or idx <= 0:
        continue

    ans = min(ans, arr[idx] - a)

print(ans if ans < 1e10 else -1)