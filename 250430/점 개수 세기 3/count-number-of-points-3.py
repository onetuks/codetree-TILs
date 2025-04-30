from sys import stdin
from sortedcontainers import SortedSet
from bisect import bisect_left

input = stdin.readline

n, q = map(int, input().split())
points = SortedSet(list(map(int, input().split())))
queries = [tuple(map(int, input().split())) for _ in range(q)]

mapper = {-1e10:1}
idx = 2
for point in points:
    mapper[point] = idx
    idx += 1

for a, b in queries:
    l = mapper[points[bisect_left(points, a)]]
    r = mapper[points[bisect_left(points, b)]]
    print(r - l + 1)