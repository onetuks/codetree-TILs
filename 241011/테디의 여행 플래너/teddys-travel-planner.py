class Node:
    def __init__(self, name):
        self.name = name
        self.prev = None
        self.post = None

    def __str__(self):
        return self.name

    def print(self):
        if not self.prev or not self.post:
            print(-1)
        elif self.prev == self.post:
            print(-1)
        else:
            print(self.prev, self.post)

def connect(s, e):
    if s:
        s.post = e
    if e:
        e.prev = s

def pop(node):
    node.prev.post = node.post
    node.post.prev = node.prev
    node.prev = None
    node.post = None

def insert(node, singleton):
    singleton.prev = node
    singleton.post = node.post

    if singleton.prev:
        singleton.prev.post = singleton
    if singleton.post:
        singleton.post.prev = singleton

n, q = map(int, input().split())
cities = list(map(Node, input().split()))

for idx, city in enumerate(cities):
    cities[idx].prev = cities[idx - 1]
    cities[idx].post = cities[(idx + 1) % n]

cur = cities[0]

for _ in range(q):
    cmd = input().split()

    if cmd[0] == '1':
        cur = cur.post
    elif cmd[0] == '2':
        cur = cur.prev
    elif cmd[0] == '3':
        pop(cur.post)
    elif cmd[0] == '4':
        insert(cur, Node(cmd[1]))
    cur.print()