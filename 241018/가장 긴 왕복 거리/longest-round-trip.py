from collections import defaultdict
from heapq import heappush, heappop

def dijkstra_full(init):
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

def dijkstra_part(init, target):
    dp = [1e11 for _ in range(n + 1)]
    dp[init] = 0

    q = [(dp[init], init)]

    while q:
        cost, node = heappop(q) 

        if node == target:
            return cost
        if dp[node] < cost:
            continue
        
        for next_cost, next_node in adj[node]:
            if dp[next_node] > dp[node] + next_cost:
                dp[next_node] = dp[node] + next_cost
                heappush(q, (dp[next_node], next_node))

    return -1e11

n, m, x = map(int, input().split())

adj = defaultdict(list)
for _ in range(m):
    u, v, w = map(int, input().split())
    adj[u].append((w, v))

ans = 0
xdp = dijkstra_full(x)
for i in range(1, n + 1): 
    if i == x:
        continue
    dist = dijkstra_part(i, x)
    ans = max(ans, xdp[i] + dist)

print(ans)