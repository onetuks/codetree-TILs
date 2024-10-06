from collections import deque, defaultdict

n, g = map(int, input().split())
member_groups = defaultdict(list)
groups = dict()

for i in range(g):
    line = list(map(int, input().split()))

    for member in line[1:]:
        member_groups[member].append(i)

    groups[i] = line[1:]

invited = set([1])
q = deque([1])

while q:
    member = q.popleft()

    gids = member_groups[member]

    for gid in gids:
        group = groups[gid]
        diff = len(group) - len(invited)
        if diff > 1:
            continue
        rest = set(group) - invited
        if len(rest) == 1:
            rest_member = rest.pop()
            invited.add(rest_member)
            q.append(rest_member)

print(len(invited))