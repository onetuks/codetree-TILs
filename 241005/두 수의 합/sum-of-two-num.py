from collections import Counter

n, k = map(int, input().split())
alist = list(map(int, input().split()))

counter = Counter(alist)
keys = list(counter.keys())

answer = 0

for i in range(len(keys) - 1):
    for j in range(i + 1, len(keys)):
        if keys[i] + keys[j] == k:
            answer += counter[keys[i]] * counter[keys[j]]

print(answer)