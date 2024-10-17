n = int(input())
m = 100000

ans = 1e11

for i in range(m // 5 + 1):
    rest = n - 5 * i
    if rest >= 0 and rest % 2 == 0:
        ans = min(ans, i + rest // 2)

if ans >= 1e11:
    print(-1)
else:
    print(ans)