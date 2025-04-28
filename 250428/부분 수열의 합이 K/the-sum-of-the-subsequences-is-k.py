import sys

input = sys.stdin.readline

n, k = map(int, input().split())
arr = list(map(int, input().split()))

ans = 0

pfsum = [0, arr[0]]
for i in range(1, n):
    pfsum.append(pfsum[-1] + arr[i])

for i in range(n + 1):
    for j in range(n + 1):
        val = pfsum[j] - pfsum[i]
        if val == k:
            ans += 1

print(ans)
