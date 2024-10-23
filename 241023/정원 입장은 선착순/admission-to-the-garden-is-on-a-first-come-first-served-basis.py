from heapq import heappush, heappop

n = int(input())
customers = []

for i in range(n):
    a, t = map(int, input().split())
    heappush(customers, (a, i, t))

ans = 0
q = []
time = 0

while customers or q:
    while customers and customers[0][0] <= time:
        a, i, t = heappop(customers)
        heappush(q, (i, a, t))

    if not q:
        time = customers[0][0]
        continue

    i, a, t = heappop(q)
    ans = max(ans, time - a)
    time += t

print(ans)