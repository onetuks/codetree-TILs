from sys import stdin
from bisect import bisect_left, bisect_right

input = stdin.readline

n, q = map(int, input().split())
psum = [0] * (n + 1)
mapper = dict()
points = list(map(int, input().split()))
points.sort()

cnt = 1
for p in points:
    mapper[p] = cnt
    psum[cnt] += 1
    cnt += 1

for i in range(1, n+1):
    psum[i] += psum[i-1]

for _ in range(q):
    a, b = map(int, input().split())
    na = bisect_left(points, a)
    nb = bisect_right(points, b)
    ans = psum[nb] - psum[na]
    print(ans)