from heapq import heappush, heappop

n, m = map(int, input().split())
arr = list()
for num in list(map(int, input().split())):
    heappush(arr, -num)

for _ in range(m):
    num = -heappop(arr)
    heappush(arr, -(num - 1))

print(-arr[0])