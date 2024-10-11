class Node:
    def __init__(self, num):
        self.num = num
        self.prev = None
        self.post = None

    def __str__(self):
        prev_num = self.prev.num if self.prev is not None else 0
        post_num = self.post.num if self.post is not None else 0
        return "%d %d %d" %(prev_num, self.num, post_num)

class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    def __str__(self):
        nums = []
        node = self.head 
        while node is not None:
            nums.append(node.num)
            node = node.post
        return str(len(nums)) + " " + ' '.join(map(str, nums))

    def insert_head(self, node):
        if node is None:
            return
        if self.head is None:
            self.head = node
            self.tail = node
        else:
            connect(node, self.head)
            self.head = node

    def insert_tail(self, node):
        if node is None:
            return
        if self.tail is None:
            self.head = node
            self.tail = node
        else:
            connect(self.tail, node)
            self.tail = node

    def pop_head(self):
        if self.head is None:
            return None
        head = self.head
        self.head = head.post
        disconnect(head, head.post)
        return head

    def pop_tail(self):
        if self.tail is None:
            return None
        tail = self.tail
        self.tail = tail.prev
        disconnect(tail.prev, tail)
        return tail

def connect(s, e):
    if s is not None:
        s.post = e
    if e is not None:
        e.prev = s

def disconnect(s, e):
    if s is not None:
        s.post = None
    if e is not None:
        e.prev = None

n, k = map(int, input().split())
q = int(input())

shelves = [LinkedList() for _ in range(k + 1)]
for i in range(1, n + 1):
    shelves[1].insert_tail(Node(i))

for _ in range(q):
    x, i, j = map(int, input().split())

    if x == 1:
        node = shelves[i].pop_head()
        shelves[j].insert_tail(node)
    elif x == 2:
        node = shelves[i].pop_tail()
        shelves[j].insert_head(node)
    elif x == 3:
        shelves[j].insert_head(shelves[i].tail)
        shelves[j].head = shelves[i].head
        if i != j:
            shelves[i].head = None
            shelves[i].tail = None
    elif x == 4:
        shelves[j].insert_tail(shelves[i].head)
        shelves[j].tail = shelves[i].tail
        if i != j:
            shelves[i].head = None
            shelves[i].tail = None

for shelf in shelves[1:]:
    print(shelf)