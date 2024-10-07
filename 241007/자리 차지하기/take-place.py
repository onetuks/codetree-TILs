from sortedcontainers import SortedSet

n, m = map(int, input().split())
arr = list(map(int, input().split()))

seats = SortedSet(range(1, m + 1))

ans = 0

for a in arr:
    idx = seats.bisect_right(a)

    if idx == 0:
        break
    else:
        ans += 1
        seats.remove(seats[idx - 1])

print(ans)