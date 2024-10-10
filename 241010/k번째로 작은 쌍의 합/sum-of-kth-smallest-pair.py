from heapq import heappush, heappop

n, m, k = map(int, input().split())
alist = list(map(int, input().split()))
blist = list(map(int, input().split()))

alist.sort()
blist.sort()

q = []

for i, a in enumerate(alist):
    heappush(q, (a + blist[0], i, 0))

for _ in range(k - 1):
    s, ai, bi = heappop(q)

    bi += 1
    if bi < m:
        heappush(q, (alist[ai] + blist[bi], ai, bi))

result = heappop(q)

print(result[0])