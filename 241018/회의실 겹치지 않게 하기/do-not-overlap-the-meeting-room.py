n = int(input())
conferences = [tuple(map(int, input().split())) for _ in range(n)]
conferences.sort(key=lambda x: (x[1], -x[0]))

ans = 0
time = 0
for s, e in conferences:
    if time <= s:
        ans += 1
        time = e

print(n - ans)