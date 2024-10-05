n = int(input())

loc = dict()

for _ in range(n):
    x, y = map(int, input().split())
    if x not in loc:
        loc[x] = y
    else:
        loc[x] = min(loc[x], y)

print(sum(loc.values()))