n = int(input())
cnt = dict()
for _ in range(n):
    x, y = map(int, input().split())
    cnt[y] = x

keys = sorted(list(cnt.keys()))
i, j = 0, n - 1

ans = 1e11

while cnt:
    a, b = keys[i], keys[j]
    
    ans = min(ans, a + b)

    cnt[a] -= 1
    cnt[b] -= 1

    if a in cnt and cnt[a] == 0:
        i += 1
        cnt.pop(a)
    if b in cnt and cnt[b] == 0:
        j -= 1
        cnt.pop(b)

print(ans)