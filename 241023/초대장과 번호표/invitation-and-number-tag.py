from collections import defaultdict, deque

n, g = map(int, input().split())

groups = [set() for _ in range(g)]
mem_gids = defaultdict(list)

for gid in range(g):
    line = list(map(int, input().split()))[1:]
    groups[gid] = set(line)

    for mid in line:
        mem_gids[mid].append(gid)


invited = set([1])
q = deque([1])

while q:
    mid = q.popleft()
    
    for gid in mem_gids[mid]:
        groups[gid].remove(mid)
        if len(groups[gid]) == 1:
            new_mid = list(groups[gid])[0]
            if new_mid not in invited:
                invited.add(new_mid)
                q.append(new_mid)

print(len(invited))