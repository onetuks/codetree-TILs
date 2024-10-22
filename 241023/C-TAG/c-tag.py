from itertools import combinations

n, m = map(int, input().split())
alist = [list(input()) for _ in range(n)]
blist = [list(input()) for _ in range(n)]

ans = 0

for case in combinations(range(m), 3):
    akeys = set(a[case[0]] + a[case[1]] + a[case[2]] for a in alist)
    bkeys = set(b[case[0]] + b[case[1]] + b[case[2]] for b in blist)

    if not (akeys & bkeys):
        ans += 1

print(ans)