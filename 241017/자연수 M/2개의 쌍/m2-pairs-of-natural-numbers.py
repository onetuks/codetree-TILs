n = int(input())
arr = []
for _ in range(n):
    x, y = map(int, input().split())
    for _ in range(x):
        arr.append(y)
arr.sort()

m = len(arr)

ans = 1e11

for i in range(m // 2):
    val = arr[i] + arr[m - 1 - i]
    ans = min(ans, val)

print(ans)