from collections import Counter

n, k = map(int, input().split())
cnter = Counter(map(int, input().split()))

ordered = sorted(list(cnter.items()), key=lambda x: (-x[1], -x[0]))
ans = map(lambda x: x[0], ordered[:k])

print(' '.join(map(str, ans)))