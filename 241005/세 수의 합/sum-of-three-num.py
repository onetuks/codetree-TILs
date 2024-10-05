from collections import defaultdict

n, k = map(int, input().split())
alist = list(map(int, input().split()))
dic = defaultdict(int)

for a in alist:
    dic[a] += 1

answer = 0
for i in range(n):
    for j in range(i + 1, n):
        a = alist[i]
        b = alist[j]
        dic[a] -= 1
        dic[b] -= 1
        answer += dic[k - a - b]
        dic[a] += 1
        dic[b] += 1

print(answer // 3)