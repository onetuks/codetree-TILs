from sortedcontainers import SortedSet

t = int(input())

for _ in range(t):
    k = int(input())
    s = SortedSet()

    for _ in range(k):
        line = input().split()

        if line[0] == 'I':
            s.add(int(line[1]))
        elif line[0] == 'D':
            if line[1] == '1' and s:
                s.remove(s[-1])
            elif line[1] == '-1' and s:
                s.remove(s[0])
        
    if not s:
        print("EMPTY")
    else:
        print(s[-1], s[0])