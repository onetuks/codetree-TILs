from sortedcontainers import SortedSet
from sys import stdin

input = stdin.readline

n, q = map(int, input().split())
psum = [0] * (n + 1)
mapper = dict()
points = SortedSet(list(map(int, input().split())))

def get_lower_bound(num):
    idx = -1
    l, r = 0, len(points) - 1
    while l <= r:
        m = (l + r) // 2
        if points[m] >= num:
            r = m - 1
            idx = m
        else:
            l = m + 1
    return idx

def get_upper_bound(num):
    idx = -1
    l, r = 0, len(points) - 1
    while l <= r:
        m = (l + r) // 2
        if points[m] <= num:
            l = m + 1
            idx = m
        else:
            r = m - 1
    return idx

cnt = 1
for p in points:
    mapper[p] = cnt
    psum[cnt] += 1
    cnt += 1

for i in range(1, n+1):
    psum[i] += psum[i-1]

# print(points)
# print(psum)

for _ in range(q):
    a, b = map(int, input().split())
    na = get_lower_bound(a)
    nb = get_upper_bound(b) + 1
    # print(a,b)
    # print(na, nb)
    ans = psum[nb] - psum[na]
    print(ans)