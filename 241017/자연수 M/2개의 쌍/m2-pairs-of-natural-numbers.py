n = int(input())
cdic = dict()
for _ in range(n):
    x, y = map(int, input().split())
    cdic[y] = x

ckeys = sorted(list(cdic.keys()))

i, j = 0, n - 1
ans = 0

while i <= j or cdic[ckeys[i]] > 0 or cdic[ckeys[j]] > 0:
    ans = max(ans, ckeys[i] + ckeys[j])

    cnt = min(cdic[ckeys[i]], cdic[ckeys[j]])

    cdic[ckeys[i]] -= cnt
    cdic[ckeys[j]] -= cnt

    if cdic[ckeys[i]] <= 0:
        i += 1
    if cdic[ckeys[j]] <= 0:
        j -= 1

print(ans)