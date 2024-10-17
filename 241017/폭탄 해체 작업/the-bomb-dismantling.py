from heapq import heappush, heappop

n = int(input())
bombs = [tuple(map(int, input().split())) for _ in range(n)]
bombs.sort(key=lambda x: (x[1], x[0]))

ans = 0
q = []
bidx = n - 1

for time in reversed(range(1, int(1e4) + 1)):
    while bidx >= 0 and time <= bombs[bidx][1]:
        heappush(q, -bombs[bidx][0])
        bidx -= 1
        
    if q:
        ans += -heappop(q)

print(ans)