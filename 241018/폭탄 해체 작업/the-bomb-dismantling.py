from heapq import heappop, heappush

n = int(input())
bombs = [tuple(map(int, input().split())) for _ in range(n)]

bombs.sort(key=lambda x: x[1])

ans = 0

q = []
idx = n - 1

for time in reversed(range(1, int(1e4) + 1)):
    while idx >= 0 and time <= bombs[idx][1]:
        heappush(q, -bombs[idx][0])
        idx -= 1
        
    if q:
        ans += -heappop(q)

print(ans)