from heapq import heappush, heappop

def dijkstra():
    for i in range(n + 1):
        dp[i] = 1e15
    dp[1] = 0

    q = [(dp[1], 1)]

    while q:
        cost, node = heappop(q)

        if dp[node] < cost:
            continue

        for next_node in range(1, n + 1):
            if adj[node][next_node] == 0:
                continue
            if dp[next_node] > dp[node] + adj[node][next_node]:
                dp[next_node] = dp[node] + adj[node][next_node]
                heappush(q, (dp[next_node], next_node))

n, m = map(int, input().split())
adj = [[0 for _ in range(n + 1)] for _ in range(n + 1)]
for _ in range(m):
    u, v, w = map(int, input().split())
    adj[u][v] = w
    adj[v][u] = w

dp = [1e15 for _ in range(n + 1)]
dijkstra()

x = n
vertices = [x]
while x != 1:
    for i in range(1, n + 1):
        if adj[x][i] == 0:
            continue
        if dp[i] + adj[i][x] == dp[x]:
            x = i
            break
    vertices.append(x)

for i in range(1, len(vertices)):
    curr, prev = vertices[i], vertices[i - 1]
    adj[curr][prev] = 0
    adj[prev][curr] = 0

dijkstra()

ans = dp[n]

if ans < 1e15:
    print(ans)
else:
    print(-1)