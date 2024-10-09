from heapq import heappush, heappop

n = int(input())
q = list()

for _ in range(n):
    num = int(input())
    if num == 0:
        if not q:
            print(0)
            continue
        print(heappop(q))
    else:
        heappush(q, num)