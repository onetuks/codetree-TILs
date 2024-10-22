from sortedcontainers import SortedSet

n, m = map(int, input().split())

nums = SortedSet([-1, n + 1])
lens = SortedSet([(-(n + 1), -1, n + 1)])

for num in list(map(int, input().split())):
    nums.add(num)

    idx = nums.bisect_left(num)

    l, r = nums[idx - 1], nums[idx + 1]
    m = nums[idx]

    lens.remove((-(r - l - 1), l, r))
    lens.add((-(m - l - 1), l, m))
    lens.add((-(r - m - 1), m, r))

    print(-lens[0][0])