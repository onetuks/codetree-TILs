from collections import defaultdict

n, k = map(int, input().split())
arr = list(map(int, input().split()))
cnt = defaultdict(int)

for a in arr:
    cnt[a] += 1

ans = 0

for a in arr:
    cnt[a] -= 1
    b = k - a
    ans += cnt[b]

print(ans)