from itertools import combinations

def recognizable(aset, bset):
    for b in bset:
        if b in aset:
            return False
    return True

n, m = map(int, input().split())

agroup = [input() for _ in range(n)]
bgroup = [input() for _ in range(n)]

ans = 0

for perm in combinations(range(m), 3):
    aset, bset = set(), set()
    for i in range(n):
        aset.add(''.join([agroup[i][p] for p in perm]))
        bset.add(''.join([bgroup[i][p] for p in perm]))

    if recognizable(aset, bset):
        ans += 1

print(ans)