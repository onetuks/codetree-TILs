from sortedcontainers import SortedSet

def add_event(x1, v1, x2, v2):
    if v1 <= v2:
        return
    events.add(((x2 - x1) / (v1 - v2), x1, v1))

def remove_event(x1, v1, x2, v2):
    if v1 <= v2:
        return
    events.remove(((x2 - x1) / (v1 - v2), x1, v1))

n, t = map(int, input().split())
x, v = list(), list()
for _ in range(n):
    ix, iv = map(int, input().split())
    x.append(ix)
    v.append(iv)

people = SortedSet()
events = SortedSet()

for i in range(n):
    people.add((x[i], v[i]))

for i in range(n - 1):
    add_event(x[i], v[i], x[i + 1], v[i + 1])

while events:
    ct, cx, cv = events[0]

    if ct > t:
        break

    people.remove((cx, cv))
    events.remove((ct, cx, cv))

    idx = people.bisect_right((cx, cv))
    nx, nv = people[idx]

    if idx > 0:
        px, pv = people[idx - 1]
        remove_event(px, pv, cx, cv)
        add_event(px, pv, nx, nv)

print(len(people))