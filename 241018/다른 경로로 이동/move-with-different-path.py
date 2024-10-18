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

        for next_node in range(1, n + 1):
            if dp[next_node] > dp[node] + adj[node][next_node]:
                dp[next_node] = dp[node] + adj[node][next_node]
                heappush(q, (dp[next_node], next_node))
                path[next_node] = node

    return dp[n]

n, m = map(int, input().split())
adj = [[1e15 for _ in range(n + 1)] for _ in range(n + 1)]
for _ in range(m):
    u, v, w = map(int, input().split())
    adj[u][v] = w
    adj[v][u] = w

path = [-1 for _ in range(n + 1)]
dijkstra()

x = n
vertices = [x]
while x != 1:
    x = path[x]
    vertices.append(x)

for i in range(1, len(vertices)):
    curr, prev = vertices[i], vertices[i - 1]
    adj[curr][prev] = 1e15
    adj[prev][curr] = 1e15

ans = dijkstra()

if ans < 1e15:
    print(ans)
else:
    print(-1)