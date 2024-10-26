n, m = map(int, input().split())
dots = list(map(int, input().split()))

def lower_bound(x):
    l, r = 0, n - 1
    min_idx = n
    while l <= r:
        m = (l + r) // 2
        if x <= dots[m]:
            min_idx = min(min_idx, m)
            r = m - 1
        else:
            l = m + 1
    return min_idx

for _ in range(m):
    s, e = map(int, input().split())
    s, e = min(s, e), max(s, e)
    s_min_idx = lower_bound(s)
    e_min_idx = lower_bound(e)
    print(e_min_idx - s_min_idx)