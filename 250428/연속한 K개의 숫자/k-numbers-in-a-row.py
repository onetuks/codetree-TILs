n, k, b = map(int, input().split())
missing = [int(input()) for _ in range(b)]

psum = [0]
s = 0
for i in range(1, n + 1):
    if i not in missing:
        s += i
    psum.append(s)

min_diff = float('inf')
min_idx = 0
for i in range(n - k + 1):
    j = i + k
    real = psum[j] - psum[i]
    expt = (j + i + 1) * k / 2
    if expt - real < min_diff:
        min_diff = expt - real
        min_idx = i + 1

ans = 0
for m in missing:
    if min_idx <= m < min_idx + k:
        ans += 1

print(ans)