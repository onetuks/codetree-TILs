def add(x):
    hash_set.add(x)

def remove(x):
    hash_set.remove(x)

def find(x):
    if x in hash_set:
        print("true")
    else:
        print("false")

n = int(input())

hash_set = set()

for _ in range(n):
    line = input().split()

    if line[0] == 'add':
        add(int(line[1]))
    elif line[0] == 'remove':
        remove(int(line[1]))
    elif line[0] == 'find':
        find(int(line[1]))