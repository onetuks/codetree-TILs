from sys import stdin
from bisect import bisect_left, bisect_right

input = stdin.readline

n, q = map(int, input().split())
points = list(map(int, input().split()))
queries = [tuple(map(int, input().split())) for _ in range(q)]

points.sort()

# 사실 누적합은 필요없음
# 해당 구간의 bisect로 해당 좌표의 인덱스를 이미 알고, 해당 좌표는 한 번만 주어지기 때문에
# bisect로만 해당 좌표보다 크거나 같은 첫번째 인덱스 (bisect_right)
# 해당 좌표보다 작거나 같은 첫번째 인덱스 (bisect_left)를 알면 모든 문제가 풀림
for a, b in queries:
    ia = bisect_left(points, a)
    ib = bisect_right(points, b)
    print(ib - ia)
