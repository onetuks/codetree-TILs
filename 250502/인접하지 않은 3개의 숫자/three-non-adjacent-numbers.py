n = int(input())
arr = list(map(int, input().split()))

l = [0] * n
r = [0] * n

l[0] = arr[0]
for i in range(1, n):
    l[i] = max(l[i-1], arr[i])

r[-1] = arr[-1]
for i in range(n-2, -1, -1):
    r[i] = max(r[i+1], arr[i])

ans = 0
for i in range(2, n-2):
    val = l[i-2] + r[i+2] + arr[i]
    ans = max(ans, val)

print(ans)