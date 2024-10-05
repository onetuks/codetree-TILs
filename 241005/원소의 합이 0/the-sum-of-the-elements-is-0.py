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

ab_keys, cd_keys = sorted(ab.keys()), sorted(cd.keys(), reverse=True)

answer = 0

for ab_key in ab_keys:
    for cd_key in cd_keys:
        if ab_key + cd_key == 0:
            answer += ab[ab_key] * cd[cd_key]
        elif ab_key + cd_key < 0:
            break

print(answer)