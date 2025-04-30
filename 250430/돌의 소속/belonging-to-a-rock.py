import sys

input = sys.stdin.readline

n, q = map(int, input().split())
one_psum = [0] * (n+1)
two_psum = [0] * (n+1)
thr_psum = [0] * (n+1)
for i in range(n):
    group = int(input())
    if group == 1: one_psum[i+1] = 1
    elif group == 2: two_psum[i+1] = 1
    else: thr_psum[i+1] = 1

for i in range(1, n+1):
    one_psum[i] += one_psum[i-1]
    two_psum[i] += two_psum[i-1]
    thr_psum[i] += thr_psum[i-1]

# print(one_psum)
# print(two_psum)
# print(thr_psum)

for _ in range(q):
    a, b = map(int, input().split())
    print(
        one_psum[b] - one_psum[a-1],
        two_psum[b] - two_psum[a-1],
        thr_psum[b] - thr_psum[a-1]
    )
    