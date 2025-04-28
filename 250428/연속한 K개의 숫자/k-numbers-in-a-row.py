n, k, b = map(int, input().split())
missing = sorted(list(map(int, input().split())))

psum = [0]
s = 0
for i in range(1, n + 1):
    if i in missing: continue
    s += i
    psum.append(s)

min_diff = float('inf')
min_idx = 0
for i in range(n - k):
    j = i + k
    real = psum[j] - psum[i]
    expt = (j + i + 1) * k / 2
    if expt - real < min_diff:
        min_diff = expt - real
        min_idx = i + 1

ans = 0
for m in missing:
    if min_idx <= m <= min_idx + k:
        ans += 1

print(ans)