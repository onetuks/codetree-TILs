from collections import Counter

n, k = map(int, input().split())
counter = Counter(map(int, input().split()))

ordered = sorted(list(counter.items()), key=lambda x: (-x[1], -x[0]))

ans = [o[0] for o in ordered[:k]]

print(' '.join(map(str, ans)))