n, m = map(int, input().split())
capacities = list(map(int, input().split()))

if n < min(capacities):
    print(-1)
else:
    answer = 0
    l, r = 1, int(1e5)
    while l <= r:
        m = (l + r) // 2
        cnt = sum([cap * m for cap in capacities])
        if cnt >= n:
            answer = m
            r = m - 1
        else:
            l = m + 1
    print(answer)