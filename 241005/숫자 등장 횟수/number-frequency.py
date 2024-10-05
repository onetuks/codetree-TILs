from collections import Counter

n, m = map(int, input().split())
olist = list(map(int, input().split()))
tlist = list(map(int, input().split()))

counter = Counter(olist)

for t in tlist:
    print(counter[t], end=" ")