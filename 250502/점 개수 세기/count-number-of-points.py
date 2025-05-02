from sys import stdin
from bisect import bisect_left, bisect_right

input = stdin.readline

n, q = map(int, input().split())
points = list(map(int, input().split()))
queries = [tuple(map(int, input().split())) for _ in range(q)]

points.sort()

for a, b in queries:
    ia = bisect_left(points, a)
    ib = bisect_right(points, b)
    print(ib - ia)
