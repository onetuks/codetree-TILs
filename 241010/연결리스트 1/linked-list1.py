class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.post = None

    def insert_prev(self, node):
        node.prev = self.prev
        node.post = self

        if node.prev is not None:
            node.prev.post = node
        if node.post is not None:
            node.post.prev = node

    def insert_post(self, node):
        node.prev = self
        node.post = self.post

        if node.prev is not None:
            node.prev.post = node
        if node.post is not None:
            node.post.prev = node

    def print_node(self):
        prev = self.prev.data if self.prev is not None else '(Null)'
        post = self.post.data if self.post is not None else '(Null)'
        print(prev, self.data, post)

s_init = input()
cur = Node(s_init)
n = int(input())
for _ in range(n):
    line = input().split()

    if line[0] == '1':
        node = Node(line[1])
        cur.insert_prev(node)
    elif line[0] == '2':
        node = Node(line[1])
        cur.insert_post(node)
    elif line[0] == '3':
        if cur.prev is not None:
            cur = cur.prev
    elif line[0] == '4':
        if cur.post is not None:
            cur = cur.post

    cur.print_node()