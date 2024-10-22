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
    if not s: s.post = e
    if not e: e.prev = s

def pop(node):
    node.prev.post = node.post
    node.post.prev = node.prev
    node.prev = None
    node.post = None

def add(node, singleton):
    singleton.post = node.post
    singleton.prev = node
    if singleton.post:
        singleton.post.prev = singleton
    if singleton.prev:
        singleton.prev.post = singleton

n, q = map(int, input().split())
cities = list(map(Node, input().split()))

for i in range(n):
    cities[i].prev = cities[i - 1]
    cities[i].post = cities[(i + 1) % n]

curr = cities[0]
for _ in range(q):
    cmds = input().split()

    if cmds[0] == '1':
        curr = curr.post
    elif cmds[0] == '2':
        curr = curr.prev
    elif cmds[0] == '3':
        pop(curr.post)
    elif cmds[0] == '4':
        add(curr, Node(cmds[1]))

    curr.print()