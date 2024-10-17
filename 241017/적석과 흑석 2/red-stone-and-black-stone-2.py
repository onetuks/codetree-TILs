c, n = map(int, input().split())
reds = [int(input()) for _ in range(c)]
blacks = [tuple(map(int, input().split())) for _ in range(n)]

reds.sort()
blacks.sort(key=lambda x: (x[1], x[0]))

ans = 0
idx = 0
for a, b in blacks:
    while idx < c and reds[idx] < a:
        idx += 1
    
    if idx < c and a <= reds[idx] <= b:
        ans += 1
        idx += 1

print(ans)