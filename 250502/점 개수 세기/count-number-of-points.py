from sortedcontainers import SortedSet
from sys import stdin

input = stdin.readline

n, q = map(int, input().split())
psum = [0] * (n + 1)
mapper = dict()
points = SortedSet(list(map(int, input().split())))
queries = [tuple(map(int, input().split())) for _ in range(q)]

cnt = 1
for p in points:
    mapper[p] = cnt
    psum[cnt] += 1
    cnt += 1

for i in range(1, n+1):
    psum[i] += psum[i-1]

for a, b in queries: 
    na = points.bisect_left(a) + 1
    nb = points.bisect_right(b)
    ans = psum[nb] - psum[na-1]
    print(ans)