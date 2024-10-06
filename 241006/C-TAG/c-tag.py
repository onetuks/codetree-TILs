from itertools import combinations

def recognizable(pos):
    aset = set()

    for i in range(n):
        aset.add(agroup[i][pos[0]] + agroup[i][pos[1]] + agroup[i][pos[2]])
        
    for i in range(n):
        if (bgroup[i][pos[0]] + bgroup[i][pos[1]] + bgroup[i][pos[2]]) in aset:
            return False

    return True
    

n, m = map(int, input().split())

agroup = [input() for _ in range(n)]
bgroup = [input() for _ in range(n)]

ans = 0

for perm in combinations(range(m), 3):
    if recognizable(perm):
        ans += 1

print(ans)