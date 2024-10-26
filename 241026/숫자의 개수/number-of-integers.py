from bisect import bisect_left, bisect_right

n, m = map(int, input().split())
arr = list(map(int, input().split()))

for _ in range(m):
    x = int(input())
    lower = bisect_left(arr, x)
    upper = bisect_right(arr, x)
    print(upper - lower)