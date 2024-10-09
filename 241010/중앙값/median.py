from heapq import heappush, heappop

t = int(input())

for _ in range(t):
    m = int(input())
    q = list()
    for idx, num in enumerate(list(map(int, input().split()))):
        heappush(q, num)
        if (idx + 1) % 2 != 0:
            temp = list()
            for _ in range((idx + 1) // 2):
                temp.append(heappop(q))
            print(q[0], end=" ")
            for t in temp:
                heappush(q, t)
    print()