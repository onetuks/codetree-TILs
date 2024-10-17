n = int(input())
cdic = dict()
for _ in range(n):
    x, y = map(int, input().split())
    cdic[y] = x

ckeys = sorted(list(cdic.keys()))

i, j = 0, n - 1
ans = 1e11

while i <= j or cdic[ckeys[i]] > 0 or cdic[ckeys[j]] > 0:
    ans = min(ans, ckeys[i] + ckeys[j])

    cdic[ckeys[i]] -= min(cdic[ckeys[i]], cdic[ckeys[j]])
    cdic[ckeys[j]] -= min(cdic[ckeys[i]], cdic[ckeys[j]])

    if cdic[ckeys[i]] == 0:
        i += 1
    if cdic[ckeys[j]] == 0:
        j -= 1

print(ans)