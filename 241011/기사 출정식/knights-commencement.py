class Node:
    def __init__(self, num):
        self.num = num
        self.prev = None
        self.post = None

    def __str__(self):
        return "%d %d" %(self.post.num, self.prev.num)

def pop(node):
    node.prev.post = node.post
    node.post.prev = node.prev
    return node

n, m = map(int, input().split())
knights = list(map(Node, list(map(int, input().split()))))
dic = dict()

for i in range(n):
    knights[i].prev = knights[i - 1]
    knights[i].post = knights[(i + 1) % n]
    dic[knights[i].num] = knights[i]

for _ in range(m):
    num = int(input())
    print(pop(dic[num]))