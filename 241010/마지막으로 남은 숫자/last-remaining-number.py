from heapq import heappush, heappop

n = int(input())

q = list()

for num in list(map(int, input().split())):
    heappush(q, -num)

while len(q) > 1:
    a, b = heappop(q), heappop(q)

    if a == b:
        continue
    
    heappush(q, (a - b))

if not q:
    print(-1)
else:
    print(-q[0])