from heapq import heappush, heappop

def dijkstra(paths):
    dp = [1e9 for _ in range(n + 1)]
    dp[1] = 0

    q = [(dp[1], 1)]

    while q:
        cost, node = heappop(q)

        if node == n:
            return cost
        if dp[node] < cost:
            continue

        for next_node in range(1, n + 1):
            if dp[next_node] > dp[node] + adj[node][next_node]:
                dp[next_node] = dp[node] + adj[node][next_node]
                heappush(q, (dp[next_node], next_node))
                if paths is not None:
                    paths[next_node] = node

    return dp[n]

n, m = map(int, input().split())
adj = [[1e10 for _ in range(n + 1)] for _ in range(n + 1)]
for _ in range(m): 
    u, v, w = map(int, input().split())
    adj[u][v] = w
    adj[v][u] = w

path = [-1 for _ in range(n + 1)]
origin = dijkstra(path)

x = n
vertices = [x]
while x != 1:
    x = path[x]
    vertices.append(x)

ans = 0
for i in range(1, len(vertices)):
    curr, prev = vertices[i], vertices[i - 1]
    weight = adj[curr][prev]
    adj[curr][prev] = 1e10
    adj[prev][curr] = 1e10
    changed = dijkstra(None)
    if origin != changed:
        ans += 1
    adj[curr][prev] = weight
    adj[prev][curr] = weight

print(ans)