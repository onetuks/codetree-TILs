from sortedcontainers import SortedSet

n, m = map(int, input().split())
s_num = SortedSet([-1, n + 1])
s_len = SortedSet([(-(n + 1), -1, n + 1)])

for num in list(map(int, input().split())):
    s_num.add(num)

    idx = s_num.bisect_left(num)

    l, r = s_num[idx - 1], s_num[idx + 1]
    m = s_num[idx]
    s_len.remove((-(r - l - 1), l, r))
    s_len.add((-(m - l - 1), l, m))
    s_len.add((-(r - m - 1), m, r))

    print(-s_len[0][0])