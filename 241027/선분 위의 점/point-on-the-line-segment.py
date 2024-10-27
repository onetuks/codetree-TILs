n, m = map(int, input().split())
dots = list(map(int, input().split()))

def upper_bound(x):
    l, r = 0, n - 1
    max_idx = -1
    while l <= r:
        m = (l + r) // 2
        if x >= dots[m]:
            max_idx = max(max_idx, m)
            l = m + 1
        else:
            r = m - 1
    return max_idx

for _ in range(m):
    s, e = map(int, input().split())
    s, e = min(s, e), max(s, e)
    s_min_idx = upper_bound(s)
    e_min_idx = upper_bound(e)
    ans = e_min_idx - s_min_idx
    if dots[s_min_idx] == s and dots[e_min_idx] == e:
        ans += 1
    print(ans)