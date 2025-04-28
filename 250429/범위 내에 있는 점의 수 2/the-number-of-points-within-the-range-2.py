n, q = map(int, input().split())
bound = int(1e6) + 1
plist = [0] * bound
psum = [0] * bound

for p in list(map(int, input().split())):
    plist[p] = 1
for i in range(1, bound):
    psum[i] = psum[i - 1] + plist[i]

for _ in range(q):
    a, b = map(int, input().split())
    print(psum[b] - psum[a - 1])