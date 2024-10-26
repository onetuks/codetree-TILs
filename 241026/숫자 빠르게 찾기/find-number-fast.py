n, m = map(int, input().split())
arr = list(map(int, input().split()))

def binsearch(x):
    l, r = 0, n
    while l <= r:
        m = (l + r) // 2
        if arr[m] == x:
            return m + 1

        if x < arr[m]:
            r = m - 1
        else:
            l = m + 1
    return -1

for _ in range(m):
    x = int(input())
    ans = binsearch(x)

    print(ans)