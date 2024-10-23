from heapq import heappush, heappop

n = int(input())
people = []

for i in range(n):
    a, t = map(int, input().split())
    people.append((i, t, a))

people.sort(key=lambda x: (x[-1]))

ans = 0

q = []
idx = 0
time = people[0][-1]

while time < 1e10:
    while idx < n and people[idx][-1] <= time:
        heappush(q, people[idx])
        idx += 1
    
    if q:
        i, t, a = heappop(q)
        ans = max(ans, time - a)
        time += t
    else:
        if not q and idx == n:
            break
        time += 1

print(ans)