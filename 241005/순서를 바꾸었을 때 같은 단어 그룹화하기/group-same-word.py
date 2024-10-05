from collections import Counter

n = int(input())

words = [''.join(sorted(input())) for _ in range(n)]

count = Counter(words)

print(max(count.values()))