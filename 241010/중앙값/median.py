from heapq import heappush, heappop

t = int(input())

for _ in range(t):
    m = int(input())
    arr = list(map(int, input().split()))
    
    median = arr[0]
    maxq, minq = [], []
    print(median, end=" ")

    for i in range(1, m):
        if i % 2 == 1: # 짝수 인덱스
            if arr[i] < median:
                heappush(maxq, -arr[i])
            else:
                heappush(minq, arr[i])

        else:
            candi = median
            if len(maxq) < len(minq):
                candi = heappop(minq)
            else:
                candi = -heappop(maxq)

            nums = sorted([median, candi, arr[i]])

            heappush(maxq, -nums[0])
            median = nums[1]
            heappush(minq, nums[-1])

            print(median, end=" ")
    print()