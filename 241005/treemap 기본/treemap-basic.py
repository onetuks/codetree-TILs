from sortedcontainers import SortedDict

def add(k, v):
    tree_map[k] = v

def remove(k):
    tree_map.pop(k)

def find(k):
    if k in tree_map:
        return tree_map[k]
    return None

def print_list():
    if tree_map:
        print(' '.join(map(str, tree_map.values())))
        return
    print(None)

n = int(input())

tree_map = SortedDict()

for _ in range(n):
    line = input().split()

    if line[0] == 'add':
        add(int(line[1]), int(line[2]))
    elif line[0] == 'find':
        print(find(int(line[1])))
    elif line[0] == 'remove':
        remove(int(line[1]))
    elif line[0] == 'print_list':
        print_list()