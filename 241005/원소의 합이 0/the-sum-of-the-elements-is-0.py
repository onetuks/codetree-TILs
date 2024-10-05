from collections import Counter

n = int(input())
a = Counter(map(int, input().split()))
b = Counter(map(int, input().split()))
c = Counter(map(int, input().split()))
d = Counter(map(int, input().split()))

ab = dict()
cd = dict()

for ka in a.keys():
    for kb in b.keys():
        ab[ka + kb] = a[ka] * b[kb]
for kc in c.keys():
    for kd in d.keys():
        cd[kc + kd] = c[kc] * d[kd]

answer = 0

for k in ab.keys():
    if -k in cd:
        answer += ab[k] * cd[-k]

print(answer)