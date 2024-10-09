from heapq import heappush, heappop

n, m = map(int, input().split())
q = list()

for _ in range(n):
    x, y = map(int, input().split())
    heappush(q, (x + y, x, y))

for _ in range(m):
    s, x, y = heappop(q)

    heappush(q, (s + 4, x + 2, y + 2))

print(' '.join(map(str, q[0][1:])))