from sys import stdin

input = stdin.readline

n = int(input())
b = [input().strip() for _ in range(n)]

l_rock = r_rock = [0] * n
l_scissor = r_scissor = [0] * n
l_paper, r_paper = [0] * n

l_paper[0] = 3
print(r_paper)

