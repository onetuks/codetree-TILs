from sortedcontainers import SortedSet

n, t = map(int, input().split())
mans = SortedSet()

for _ in range(n):
    s, v = map(int, input().split())
    mans.add((s, v))

ans = 1

for i in range(1, n):
    s1, v1 = mans[i - 1]
    s2, v2 = mans[i]
    if s1 + v1 * t >= s2 + v2 * t:
        continue
    ans += 1
    
print(ans)