from collections import deque, defaultdict

n, g = map(int, input().split())
uninvited = defaultdict(set)
mem_gids = [list() for _ in range(n + 1)]

for i in range(g):
    nums = list(map(int, input().split()))[1:]

    for num in nums:
        uninvited[i].add(num)
        mem_gids[num].append(i)

q = deque([1])
invited = set([1])

while q:
    mem = q.popleft()

    for gid in mem_gids[mem]:
        if mem in uninvited[gid]:
            uninvited[gid].remove(mem)
        if len(uninvited[gid]) == 1:
            rest = uninvited[gid].pop()
            if rest not in invited:
                invited.add(rest)
                q.append(rest)

print(len(invited))