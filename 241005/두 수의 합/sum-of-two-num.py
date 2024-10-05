from collections import Counter

n, k = map(int, input().split())
alist = list(map(int, input().split()))
counter = Counter(alist)

answer = 0

for k1, v in counter.items():
    k2 = k - k1
    if k1 == k2:
        answer += v * (v - 1)
    else:
        answer += v * counter[k2]

print(answer // 2)