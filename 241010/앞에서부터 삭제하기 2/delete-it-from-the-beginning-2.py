from heapq import heappush, heappop

n = int(input())
arr = list(map(int, input().split()))

min_num = arr[-1]
acc_sum = 0
min_arr = [a for a in arr]
acc_arr = [a for a in arr]
for i in reversed(range(n - 1)):
    min_arr[i] = min(min_arr[i], min_arr[i + 1])
    acc_arr[i] += acc_arr[i + 1]

q = list()

for i in range(1, n - 1):
    avg = (acc_arr[i] - min_arr[i]) / (n - i - 1)
    heappush(q, -avg)

print("%.2f" %-heappop(q))