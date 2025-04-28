n, q = map(int, input().split())
plist = [0] * int(1e6)
psum = [0] * int(1e6)

for p in list(map(int, input().split())):
    plist[p] = 1
for i in range(1, len(plist)):
    psum[i] = psum[i - 1] + plist[i]

for _ in range(q):
    a, b = map(int, input().split())
    print(psum[b] - psum[a - 1])