from collections import defaultdict

n, g = map(int, input().split())
invited = {1}

groups_of_members = defaultdict(list)
for _ in range(g):
    line = list(map(int, input().split()))[1:]
    for member in line:
        groups_of_members[member].append(set(line))
    
for member in range(1, n + 1):
    groups = groups_of_members[member]
    for group in groups:
        rest = group - invited
        if len(rest) == 1:
            invited.add(list(rest)[0])

print(len(invited))