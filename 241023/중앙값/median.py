from heapq import heappush, heappop

t = int(input())
for _ in range(t):
    m = int(input())
    arr = list(map(int, input().split()))

    maxq, minq = [], []
    mid = arr[0]
    print(mid, end=" ")

    for i, a in enumerate(arr[1:]):
        if i % 2 == 0:
            if mid < a: 
                heappush(minq, a)
            else:
                heappush(maxq, -a)
        else:
            temp = [mid, a]
            if len(minq) < len(maxq):
                temp.append(-heappop(maxq))
            else:
                temp.append(heappop(minq))
            temp.sort()

            heappush(maxq, -temp[0])
            mid = temp[1]
            heappush(minq, temp[-1])

            print(mid, end=" ")
    print()