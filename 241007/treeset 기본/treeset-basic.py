from sortedcontainers import SortedSet

n = int(input())

s = SortedSet()

for _ in range(n): 
    line = input().split()

    if line[0] == 'add':
        s.add(int(line[1]))
    elif line[0] == 'remove':
        s.remove(int(line[1]))
    elif line[0] == 'find':
        print('true' if int(line[1]) in s else 'false')
    elif line[0] == 'lower_bound':
        idx = s.bisect_left(int(line[1]))
        if idx < len(s):
            print(s[idx])
        else:
            print(None)
    elif line[0] == 'upper_bound':
        idx = s.bisect_right(int(line[1]))
        if idx < len(s):
            print(s[idx])
        else:
            print(None)
    elif line[0] == 'largest':
        if not s:
            print(None)
        else:
            print(s[-1])
    elif line[0] == 'smallest':
        if not s:
            print(None)
        else:
            print(s[0])