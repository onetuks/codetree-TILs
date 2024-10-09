from heapq import heappop, heappush

n = int(input())
q = []

for _ in range(n):
    x = int(input())

    if x == 0:
        if not q:
            print(0)
            continue
        abx, orx = heappop(q)
        print(orx)
    else:
        heappush(q, (abs(x), x))