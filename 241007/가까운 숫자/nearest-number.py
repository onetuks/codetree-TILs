from sortedcontainers import SortedSet

n = int(input())
s = SortedSet([0])
diffs = SortedSet()

for num in list(map(int, input().split())):
    s.add(num)
    idx = s.bisect_left(num)
    if 0 <= idx + 1 < len(s):
        diffs.add(s[idx + 1] - s[idx])
    if 0 <= idx - 1 < len(s):
        diffs.add(s[idx] - s[idx - 1])

    print(diffs[0])