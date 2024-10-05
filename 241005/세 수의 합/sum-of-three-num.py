from collections import defaultdict

n, k = map(int, input().split())
arr = list(map(int, input().split()))
cnt = defaultdict(int)

for ar in arr:
    cnt[ar] += 1

ans = 0

for i in range(n):
    cnt[arr[i]] -= 1
    for j in range(i):
        diff = k - arr[i] - arr[j]
        ans += cnt[diff]

print(ans)