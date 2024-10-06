n, g = map(int, input().split())
groups = [list(map(int, input().split())) for _ in range(g)]

groups.sort(key=lambda x: x)

invited = set([1])

for group in groups:
    members = set(group[1:])
    rest = members - invited

    if len(rest) <= 1:
        invited |= members

print(len(invited))