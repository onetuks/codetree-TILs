class Node:
    def __init__(self, id):
        self.id = id
        self.prev = None
        self.post = None
    
    def print(self):
        prev = self.prev.id if self.prev is not None else 0
        post = self.post.id if self.post is not None else 0
        print(prev, post)

def insert_prev(node, singleton):
    singleton.prev = node.prev
    singleton.post = node

    if singleton.prev is not None:
        singleton.prev.post = singleton
    if singleton.post is not None:
        singleton.post.prev = singleton

def insert_post(node, singleton):
    singleton.prev = node
    singleton.post = node.post

    if singleton.prev is not None:
        singleton.prev.post = singleton
    if singleton.post is not None:
        singleton.post.prev = singleton

def pop(node):
    if node.prev is not None:
        node.prev.post = node.post
    if node.post is not None:
        node.post.prev = node.prev


n = int(input())
q = int(input())

nodes = dict()
for i in range(1, n + 1):
    nodes[i] = Node(i)

for _ in range(q):
    line = list(map(int, input().split()))

    if line[0] == 1:
        pop(nodes[line[1]])
    elif line[0] == 2:
        insert_prev(nodes[line[1]], nodes[line[-1]])
    elif line[0] == 3:
        insert_post(nodes[line[1]], nodes[line[-1]])
    elif line[0] == 4:
        nodes[line[1]].print()

for i in range(1, n + 1):
    post = nodes[i].post
    if post is None:
        print(0, end=" ")
    else:
        print(post.id, end=" ")