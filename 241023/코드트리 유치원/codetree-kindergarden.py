class Node:
    def __init__(self, id):
        self.id = id
        self.prev = None
        self.post = None

    def __str__(self):
        return str(self.id)

    def print(self):
        if self.prev and self.post:
            print(self.prev, self.post)
        else:
            print(-1)


def connect(s, e):
    if s: s.post = e
    if e: e.prev = s


def insert_back(a, s, e):
    connect(e, a.post)
    connect(a, s)


def insert_front(a, s, e):
    connect(a.prev, s)
    connect(e, a)


q = int(input())

idx = 1
nodes = [None for _ in range(100001)]
nodes[idx] = Node(idx)

for _ in range(q):
    cmd = list(map(int, input().split()))

    if cmd[0] == 1:
        a, b = cmd[1], cmd[2]
        for i in range(b):
            idx += 1
            nodes[idx] = Node(idx)
            if i > 0:
                connect(nodes[idx - 1], nodes[idx])
        insert_back(nodes[cmd[1]], nodes[idx - b + 1], nodes[idx])
    elif cmd[0] == 2:
        a, b = cmd[1], cmd[2]
        for i in range(b):
            idx += 1
            nodes[idx] = Node(idx)
            if i > 0:
                connect(nodes[idx - 1], nodes[idx])
        insert_front(nodes[cmd[1]], nodes[idx - b + 1], nodes[idx])
    else: 
        nodes[cmd[1]].print()