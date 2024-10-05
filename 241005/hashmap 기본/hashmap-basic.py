def add(k, v):
    dic[k] = v

def remove(k):
    dic.pop(k)

def find(k):
    if k not in dic:
        return None
    return dic[k]

n = int(input())
dic = dict()

for _ in range(n):
    line = input().split()

    if line[0] == 'add':
        add(int(line[1]), int(line[2]))
    elif line[0] == 'find':
        target = find(int(line[1]))
        print(target)
    elif line[0] == 'remove':
        remove(int(line[1]))