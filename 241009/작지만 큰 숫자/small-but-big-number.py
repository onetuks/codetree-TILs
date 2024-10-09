from sortedcontainers import SortedSet

n, m = map(int, input().split())
arr = SortedSet(map(int, input().split()))
for num in list(map(int, input().split())):
    idx = arr.bisect_right(num)
    if idx == 0:
        print(-1)
    else:
        target = arr[idx - 1]
        arr.remove(target)
        print(target)