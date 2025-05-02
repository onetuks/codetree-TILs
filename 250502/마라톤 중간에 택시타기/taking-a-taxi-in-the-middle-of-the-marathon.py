from sys import stdin

input = stdin.readline

def get_dist(i, j):
    return abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1])

n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]

llist = [0] * n
rlist = [0] * n

for i in range(n-1):
    llist[i+1] = llist[i] + get_dist(i, i+1)

for i in reversed(range(1, n)):
    rlist[i-1] = rlist[i] + get_dist(i-1, i)

ans = 1e9
for i in range(1, n-1):
    dist = llist[i-1] + rlist[i+1] + get_dist(i-1, i+1)
    ans = min(ans, dist)

print(ans)