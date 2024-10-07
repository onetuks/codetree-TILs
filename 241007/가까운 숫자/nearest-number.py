from sortedcontainers import SortedSet

n = int(input())
arr = list(map(int, input().split()))
s = SortedSet([0])

for a in arr:
    s.add(a)
    min_dist = 1e10
    for i in range(1, len(s)):
        idx = s.bisect_left(s[i])
        min_dist = min(min_dist, s[idx] - s[idx - 1])

    print(min_dist)