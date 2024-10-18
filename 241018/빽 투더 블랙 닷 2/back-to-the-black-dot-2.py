from collections import defaultdict
from heapq import heappush, heappop

def dijkstra(init):
    dp = [1e11 for _ in range(n + 1)]
    dp[init] = 0

    q = [(dp[init], init)]

    while q:
        cost, node = heappop(q)

        if dp[node] < cost:
            continue

        for next_cost, next_node in adj[node]:
            if dp[next_node] > next_cost + dp[node]:
                dp[next_node] = next_cost + dp[node]
                heappush(q, (dp[next_node], next_node))

    return dp

n, m = map(int, input().split())

ared, bred = map(int, input().split())

adj = defaultdict(list)
for _ in range(m):
    u, v, w = map(int, input().split())
    adj[u].append((w, v))
    adj[v].append((w, u))

adp = dijkstra(ared)
bdp = dijkstra(bred)

ans = 1e11

for i in range(1, n + 1):
    if i in [ared, bred]:
        continue
    ans = min(ans, adp[i] + adp[bred] + bdp[i])

print(ans)