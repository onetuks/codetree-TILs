n, m = map(int, input().split())
capacities = sorted(list(map(int, input().split())))

if n < min(capacities):
    print(-1)
else:
    answer = 0
    l, r = 1, int(1e5)
    while l <= r:
        m = (l + r) // 2
        cnt = sum([cap * (m - 1) for cap in capacities])
        for cap in capacities:
            if cap <= n - cnt:
                cnt += cap
        if cnt >= n:
            answer = m
            r = m - 1
        else:
            l = m + 1
    print(answer)