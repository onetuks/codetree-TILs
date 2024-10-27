n, m = map(int, input().split())
dots = list(map(int, input().split()))

def lower_bound(x):
    l, r = 0, n - 1
    min_idx = n
    while l <= r:
        m = (l + r) // 2
        if dots[m] >= x:
            min_idx = min(min_idx, m)
            r = m - 1
        else:
            l = m + 1
    return min_idx

def upper_bound(x):
    l, r = 0, n - 1
    min_idx = n
    while l <= r:
        m = (l + r) // 2
        if dots[m] > x:
            min_idx = min(min_idx, m)
            r = m - 1
        else:
            l = m + 1
    return min_idx

for _ in range(m):
    s, e = map(int, input().split())
    s, e = min(s, e), max(s, e)
    s_min_idx = upper_bound(s)
    e_min_idx = upper_bound(e)
    ans = e_min_idx - s_min_idx
    # print(s_min_idx, e_min_idx)
    if 0 <= s_min_idx < n and 0 <= e_min_idx < n and dots[s_min_idx] == s and dots[e_min_idx] == e:
        ans += 1
    print(ans)