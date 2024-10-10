from heapq import heappop, heappush

n = int(input())
q = []

for num in list(map(int, input().split())):
    heappush(q, num)
    if len(q) < 3:
        print(-1)
    else:
        ans = 1
        temp = []
        for _ in range(3):
            val = heappop(q)
            temp.append(val)
            ans *= val
        for t in temp:
            heappush(q, t)
        print(ans)