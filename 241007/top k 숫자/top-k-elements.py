from sortedcontainers import SortedSet

n, k = map(int, input().split())
arr = SortedSet(map(int, input().split()))

print(' '.join(map(str, reversed(arr[len(arr) - k:]))))