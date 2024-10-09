from sortedcontainers import SortedSet

n, t = map(int, input().split())
tracks = [tuple(map(int, input().split())) for _ in range(n)]

es = [s + v * t for s, v in tracks]

for i in reversed(range(1, len(es))):
    if es[i - 1] >= es[i]:
        es[i - 1] = es[i]
    
print(len(SortedSet(es)))