n, q = map(int, input().split())
bound = int(1e6) + 10
psum = [0] * (bound + 1)

for p in list(map(int, input().split())):
    psum[p] += 1
for i in range(1, bound):
    psum[i] += psum[i - 1]

for _ in range(q):
    a, b = map(int, input().split())
    print(psum[b] - psum[a - 1])