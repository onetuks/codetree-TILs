from heapq import heappush, heappop

n = int(input())
arr = list(map(int, input().split()))

ans = 0

for k in range(1, n - 1):
    rest = arr[k:]
    q = list()

    for r in rest:
        heappush(q, r)

    heappop(q)

    s = 0
    cnt = 0
    while q:
        s += heappop(q)
        cnt += 1
    
    ans = max(ans, round(s / cnt, 2))

print("%.2f" %ans)