from sortedcontainers import SortedSet

n, t = map(int, input().split())
tracks = SortedSet(tuple(map(int, input().split())) for _ in range(n))

for i in reversed(range(1, n)):
    s1, v1 = tracks[i - 1]
    s2, v2 = tracks[i]
    if s1 + v1 * t >= s2 + v2 * t:
        tracks.remove(tracks[i - 1])
    
print(len(tracks))