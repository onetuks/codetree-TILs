from sys import stdin

input = stdin.readline

n = int(input())
lines = [tuple(map(int, input().split())) for _ in range(n)]

lines.sort()

L = [0] * n
R = [0] * n

L[0] = lines[0][1]
R[-1] = lines[-1][1]

for i in range(1, n):
    L[i] = max(L[i-1], lines[i][1])

for i in reversed(range(n-1)):
    R[i] = min(R[i+1], lines[i][1])

ans = 0
for i in range(n):
    _, x2 = lines[i]
    if i > 0 and L[i-1] >= x2:
        continue
    if i < n - 1 and R[i+1] <= x2:
        continue
    ans += 1

print(ans)
