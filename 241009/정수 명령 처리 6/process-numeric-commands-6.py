from heapq import heappush, heappop

n = int(input())
pq = list()

for _ in range(n):
    line = input().split()

    if line[0] == 'push':
        heappush(pq, -int(line[1]))
    elif line[0] == 'pop':
        print(-heappop(pq))
    elif line[0] == 'size':
        print(len(pq))
    elif line[0] == 'empty':
        if not pq:
            print(1)
        else:
            print(0)
    elif line[0] == 'top':
        print(-pq[0])