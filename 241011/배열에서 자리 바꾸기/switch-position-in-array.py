class Node:
    def __init__(self, val):
        self.val = val
        self.prev = None
        self.post = None

def connect(s, e):
    if s is not None:
        s.post = e
    if e is not None:
        e.prev = s

def swap(anode, bnode, cnode, dnode):
    aprev, bpost = anode.prev, bnode.post
    cprev, dpost = cnode.prev, dnode.post
    
    if bpost == cnode:
        cprev = dnode
        bpost = anode
    if dpost == anode:
        dpost = cnode
        aprev = bnode

    connect(cprev, anode)
    connect(bnode, dpost)
    connect(aprev, cnode)
    connect(dnode, bpost)

n = int(input())
q = int(input())

nodes = dict()

for i in range(1, n + 1):
    nodes[i] = Node(i)
    if i > 1:
        connect(nodes[i - 1], nodes[i])

for _ in range(q):
    a, b, c, d = map(int, input().split())
    swap(nodes[a], nodes[b], nodes[c], nodes[d])

node = None
for k in nodes.keys():
    if nodes[k].prev is None:
        node = nodes[k]
        break

while node is not None:
    print(node.val, end=" ")
    node = node.post