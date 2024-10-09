from sortedcontainers import SortedSet

n, t = map(int, input().split())
# tracks = [tuple(map(int, input().split())) for _ in range(n)]

# es = [s + v * t for s, v in tracks]

# for i in reversed(range(1, len(es))):
#     if es[i - 1] >= es[i]:
#         es[i - 1] = es[i]
    
# print(len(SortedSet(es)))

tracks = SortedSet()

for _ in range(n):
    s, v = map(int, input().split())
    tracks.add((s, v))

for i in reversed(range(1, n)):
    s1, v1 = tracks[i] # 뒤에서 출발한 애
    s2, v2 = tracks[i - 1] # 앞에서 출발한 애
    if s1 + v1 * t <= s2 + v2 * t: # 추월당함
        tracks.remove(tracks[i - 1])

print(len(tracks))