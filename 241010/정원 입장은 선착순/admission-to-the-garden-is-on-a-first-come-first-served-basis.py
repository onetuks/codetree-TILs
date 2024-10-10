from heapq import heappush, heappop

n = int(input())
customers = []
for i in range(n):
    a, t = map(int, input().split())
    heappush(customers, (a, i, t))

max_wait_time = 0
curr_time = customers[0][0]
q = []
while customers or q:
    while customers and curr_time >= customers[0][0]:
        a, i, t = heappop(customers)
        heappush(q, (i, a, t))

    if not q:
        if customers:
            curr_time = customers[0][0]
        continue

    i, a, t = heappop(q)
    max_wait_time = max(max_wait_time, curr_time - a)
    curr_time += t

print(max_wait_time)