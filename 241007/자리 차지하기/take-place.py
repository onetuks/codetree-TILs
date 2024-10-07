from sortedcontainers import SortedSet

n, m = map(int, input().split())
seats = [SortedSet(list(range(1, i + 1))) for i in range(m + 1)]

ans = 0

for num in list(map(int, input().split())):
    seat = seats[num]
    if not seat:
        break
    idx = seat.bisect_left(num)
    seats[num].remove(seat[idx])
    ans += 1

print(ans)