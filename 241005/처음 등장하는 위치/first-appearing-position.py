from sortedcontainers import SortedDict

n = int(input())
arr = list(map(int, input().split()))

orders = SortedDict()

for i, a in enumerate(arr):
    if a not in orders:
        orders[a] = i + 1

for k, v in orders.items():
    print(k, v)