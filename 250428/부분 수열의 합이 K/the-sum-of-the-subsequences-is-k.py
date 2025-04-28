n, k = map(int, input().split())
arr = list(map(int, input().split()))

psum = []
s = 0
for a in arr:
    s += a
    psum.append(s)

ans = 0
i, j = 0, 1
while i < n and j < n:
    sval = psum[j] - psum[i]
    # print(i, j, sval)
    if sval < k: j += 1
    elif sval == k:
        i += 1
        j += 1
        ans += 1
    else: i += 1

for p in psum:
    if p == k:
        ans += 1

print(ans)