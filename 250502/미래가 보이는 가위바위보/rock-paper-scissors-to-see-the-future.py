N = int(input())
shapes = [input().strip() for _ in range(n)]

L = [0] * n
R = [0] * n

for shape in "PHS":
    same_cnt = 0
    for i in range(N):
        if shapes[i] == shape:
            same_cnt += 1
        L[i] = max(L[i], same_cnt)

for shape in "PHS":
    same_cnt = 0
    for i in reversed(range(N)):
        if shapes[i] == shape:
            same_cnt += 1
        R[i] = max(R[i], same_cnt)

ans = 0
for i in range(N - 1):
    ans = max(ans, L[i] + R[i+1])

print(ans)