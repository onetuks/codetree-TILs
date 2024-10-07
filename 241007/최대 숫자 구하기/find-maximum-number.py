from sortedcontainers import SortedSet

n, m = map(int, input().split())
balls = SortedSet(range(1, m + 1))

nums = list(map(int, input().split()))

for num in nums:
    balls.remove(num)
    print(balls[-1])