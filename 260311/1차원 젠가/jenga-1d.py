n = int(input())
blocks = [int(input()) for _ in range(n)]
s1, e1 = map(int, input().split())
s2, e2 = map(int, input().split())

def remove_blocks(s, e):
    global blocks
    temp = list()
    for idx, block in enumerate(blocks):
        if s - 1 <= idx <= e - 1:
            continue
        temp.append(block)
    blocks = temp

remove_blocks(s1, e1)
remove_blocks(s2, e2)

print(len(blocks))
for block in blocks:
    print(block)
