from collections import deque

n, g = map(int, input().split())
groups = deque([0] + list(map(int, input().split())) for _ in range(g))

invited = set([1])

while groups:
    group = groups.popleft()
    members = set(group[2:])
    rest = members - invited

    if len(rest) <= 1:
        invited |= members
        continue
    if group[0] > 100:
        continue
    group = [group[0] + 1] + group[1:]
    groups.append(group)


print(len(invited))