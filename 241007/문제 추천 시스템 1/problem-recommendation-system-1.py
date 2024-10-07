from sortedcontainers import SortedSet

n = int(input())
probs = SortedSet()

for _ in range(n):
    p, l = map(int, input().split())
    probs.add((l, p))

m = int(input())

for _ in range(m):
    line = input().split()

    if line[0] == 'rc':
        if line[1] == '1':
            print(probs[-1][1])
        else: 
            print(probs[0][1])
    elif line[0] == 'ad':
        probs.add((int(line[2]), int(line[1])))
    elif line[0] == 'sv':
        probs.remove((int(line[2]), int(line[1])))