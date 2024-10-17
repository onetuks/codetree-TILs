c, n = map(int, input().split())
reds = [int(input()) for _ in range(c)]
blacks = [tuple(map(int, input().split())) for _ in range(n)]

reds.sort()
blacks.sort()

ans = 0
idx = 0
for a, b in blacks:
    while reds[idx] < a:
        idx += 1
    
    if a <= reds[idx] <= b:
        ans += 1
        idx += 1

print(ans)