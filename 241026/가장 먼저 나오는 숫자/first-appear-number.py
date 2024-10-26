n, m = map(int, input().split())
arr = list(map(int, input().split()))

def lower_bound(x):
    l, r = 0, n - 1
    min_idx = n
    while l <= r:
        m = (l + r) // 2
        if x == arr[m]:
            min_idx = min(min_idx, m)
        if x <= arr[m]:
            r = m - 1
        else:
            l = m + 1
    return min_idx

for x in list(map(int, input().split())):
    ans = lower_bound(x)
    if 0 <= ans < n and arr[ans] == x:
        print(ans + 1)
    else:
        print(-1)