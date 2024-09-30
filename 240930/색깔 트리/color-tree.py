nodes = dict()


class Node:
    def __init__(self, m_id, p_id, color, max_depth, children):
        self.m_id = m_id
        self.p_id = p_id
        self.color = color
        self.max_depth = max_depth
        self.children = children

    def __str__(self):
        return "%d %d %d %d %s" %(self.m_id, self.p_id, self.color, self.max_depth, [child.m_id for child in self.children])


def add(m_id, p_id, color, max_depth):
    curr_node = Node(m_id, p_id, color, max_depth, [])
    if p_id == -1:
        nodes[m_id] = curr_node
        return
    if nodes[p_id].max_depth <= 1:
        return
    nodes[p_id].children.append(curr_node)
    nodes[m_id] = curr_node
    

def change(m_id, color):
    nodes[m_id].color = color
    for child in nodes[m_id].children:
        change(child.m_id, color)


def search(m_id):
    print(nodes[m_id].color)


def calculate(node, color_set):
    color_set.add(node.color)
    for child in node.children:
        color_set = color_set | calculate(child, color_set)
    return color_set


def main():
    q = int(input())

    for _ in range(q):
        line = list(map(int, input().split()))

        if line[0] == 100:
            add(line[1], line[2], line[3], line[4])
        elif line[0] == 200:
            change(line[1], line[2])
        elif line[0] == 300:
            search(line[1])
        elif line[0] == 400:
            value = 0
            for node in nodes.values():
                color_set = calculate(node, set())
                value += len(color_set) ** 2
            print(value) 


main()