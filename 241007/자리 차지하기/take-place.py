from sortedcontainers import SortedSet

n, m = map(int, input().split())
seats = SortedSet(range(1, m + 1))

ans = 0

for num in list(map(int, input().split())):
    idx = seats.bisect_right(num)

    if 0 <= idx - 1 < m:
        ans += 1
        seats.remove(seats[idx - 1])

print(ans)