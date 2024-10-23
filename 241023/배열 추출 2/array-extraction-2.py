from heapq import heappush, heappop

n = int(input())

q = []

for _ in range(n): 
    x = int(input())

    if x != 0:
        heappush(q, (abs(x), x))
    else:
        if not q:
            print(0)
            continue
        print(heappop(q)[1])