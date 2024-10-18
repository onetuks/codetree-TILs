from collections import defaultdict
from heapq import heappush, heappop

def dijkstra():
    dp = [1e15 for _ in range(n + 1)]
    dp[1] = 0

    q = [(dp[1], 1)]

    while q:
        cost, node = heappop(q)

        if node == n:
            return cost
        if dp[node] < cost:
            continue

        for next_cost, next_node in adj[node]:
            if dp[next_node] > dp[node] + next_cost:
                dp[next_node] = dp[node] + next_cost
                heappush(q, (dp[next_node], next_node))
                path[next_node] = node

    return dp[n]

def find_idx(curr, prev):
    for i in range(len(adj[curr])):
        if adj[curr][i][1] == prev:
            return i
    return -1

def get_vertices():
    x = n
    vertices = [x]
    while x != 1:
        x = path[x]
        vertices.append(x)
    return vertices

n, m = map(int, input().split())
adj = defaultdict(list)
for _ in range(m):
    u, v, w = map(int, input().split())
    adj[u].append([w, v])
    adj[v].append([w, u])

path = [-1 for _ in range(n + 1)]

ans = 0

origin_dist = dijkstra()
vertices = get_vertices()

for i in range(1, len(vertices)):
    cv, pv = vertices[i], vertices[i - 1]
    idx = find_idx(cv, pv)
    adj[cv][idx][0] *= 2
    dist = dijkstra()
    ans = max(ans, dist - origin_dist)
    adj[cv][idx][0] //= 2
    
print(ans)