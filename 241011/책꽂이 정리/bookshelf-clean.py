class Node:
    def __init__(self, id):
        self.id = id
        self.prev = None
        self.post = None

def is_empty(num):
    return heads[num] == 0

def connect(s, e):
    if s:
        s.post = e
    if e:
        e.prev = s

def pop_front(num):
    node = nodes[heads[num]] 
    if not node:
        return None

    if node.post:
        heads[num] = node.post.id
        node.post.prev = None
    else:
        heads[num] = 0
        tails[num] = 0

    node.post = None
    
    return node

def pop_back(num):
    node = nodes[tails[num]]
    if not node:
        return None

    if node.prev:
        tails[num] = node.prev.id
        node.prev.post = None
    else:
        heads[num] = 0
        tails[num] = 0

    node.prev = None

    return node

def push_front(num, node):
    head = nodes[heads[num]]
    if head:
        connect(node, head)
        heads[num] = node.id
    else:
        heads[num] = node.id
        tails[num] = node.id

def push_back(num, node):
    tail = nodes[tails[num]]
    if tail:
        connect(tail, node)
        tails[num] = node.id
    else:
        heads[num] = node.id
        tails[num] = node.id

def move_all_front(i, j):
    if i == j or is_empty(i):
        return
    
    if is_empty(j):
        heads[j] = heads[i]
        tails[j] = tails[i]
    else:
        connect(nodes[tails[i]], nodes[heads[j]])
        heads[j] = heads[i] 
    
    heads[i] = tails[i] = 0

def move_all_back(i, j):
    if i == j or is_empty(i):
        return

    if is_empty(j):
        heads[j] = heads[i]
        tails[j] = tails[i]
    else:
        connect(nodes[tails[j]], nodes[heads[i]])
        tails[j] = tails[i]
    
    heads[i] = tails[i] = 0

n, k = map(int, input().split())
q = int(input())

heads = [0] * (k + 1)
tails = [0] * (k + 1)

nodes = [None] + [Node(i) for i in range(1, n + 1)]

for i in range(1, n):
    connect(nodes[i], nodes[i + 1])

heads[1] = 1
tails[1] = n

for _ in range(q):
    x, i, j = map(int, input().split())

    if x == 1:
        target = pop_front(i)
        if target:
            push_back(j, target)
    elif x == 2:
        target = pop_back(i)
        if target:
            push_front(j, target)
    elif x == 3:
        move_all_front(i, j)
    elif x == 4:
        move_all_back(i, j)

for i in range(1, k + 1):
    ids = []
    node = nodes[heads[i]]
    while node:
        ids.append(node.id)
        node = node.post

    print(len(ids), ' '.join(map(str, ids)))