from sortedcontainers import SortedSet

n = int(input())
probs = SortedSet()

for _ in range(n):
    p, l = map(int, input().split())
    probs.add((l, p))

m = int(input())
for _ in range(m):
    cmd = input().split()

    if cmd[0] == 'rc':
        if cmd[1] == '1':
            print(probs[-1][1])
        else:
            print(probs[0][1])
    elif cmd[0] == 'ad':
        probs.add((int(cmd[-1]), int(cmd[1])))
    elif cmd[0] == 'sv':
        probs.remove((int(cmd[-1]), int(cmd[1])))