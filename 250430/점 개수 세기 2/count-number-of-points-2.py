from sortedcontainers import SortedSet
from bisect import bisect_left

n, q = map(int, input().split())

points = SortedSet([tuple(map(int, input().split())) for _ in range(n)])
queries = [tuple(map(int, input().split())) for _ in range(q)]

mapper = dict()
cnt = 1
for point in points:
    mapper[point] = cnt
    cnt += 1

for i, j, x, y in queries:
    v2 = mapper[points[min(n-1, bisect_left(points, (x, y)))]]
    v1 = mapper[points[bisect_left(points, (i, j))]]
    print(v2 - v1)
