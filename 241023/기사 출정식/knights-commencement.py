class Node:
    def __init__(self, id):
        self.id = id
        self.prev = None
        self.post = None

    def __str__(self):
        return self.id

    def print(self):
        print(self.post, self.prev)

def pop(id):
    dic[id].prev.post = dic[id].post
    dic[id].post.prev = dic[id].prev
    dic[id].prev = dic[id].post = None

n, m = map(int, input().split())
knights = list(map(Node, input().split()))
dic = dict()

for i in range(n):
    knights[i].prev = knights[i - 1]
    knights[i].post = knights[(i + 1) % n]
    dic[knights[i].id] = knights[i]

for _ in range(m):
    id = input().strip()
    dic[id].print()
    pop(id)