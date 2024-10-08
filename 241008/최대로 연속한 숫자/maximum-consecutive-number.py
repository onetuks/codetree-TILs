from sortedcontainers import SortedSet

n, m = map(int, input().split())
removed = SortedSet([-1, n + 1])
locs = {(-1, n + 1): n + 1}

for num in list(map(int, input().split())):
    removed.add(num)

    idx = removed.bisect_left(num)

    locs.pop((removed[idx - 1], removed[idx + 1]))
    locs[(removed[idx - 1], removed[idx])] = removed[idx] - removed[idx - 1] - 1
    locs[(removed[idx], removed[idx + 1])] = removed[idx + 1] - removed[idx] - 1

    print(max(locs.values()))