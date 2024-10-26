n, m = map(int, input().split())
arr = list(map(int, input().split()))

# 찾고자 하는 값 중에 가장 작은 idx 찾기
# 찾은 값이 찾고자 하는 값보다 크거나 같은 값 중에 가장 작은 idx
# arr[m] >= x -> min(m)
# 내가 찾은 값은 타겟보다 큰 값이니까 줄여줘야 함
def lower_bound(x):
    l, r = 0, n - 1
    min_idx = n
    while l <= r:
        m = (l + r) // 2
        if arr[m] >= x:
            min_idx = min(min_idx, m)
            r = m - 1
        else:
            l = m + 1
    return min_idx

# 찾고자 하는 값보다 큰 첫 값
# 찾은 값이 찾고자 하는 값보다 큰 경우 중에서 최소 idx
# arr[m] > x -> min(m)
# 현재보다 더 작은 값이 있을 수 있으므로 범위를 줄여야 함
def upper_bound(x):
    l, r = 0, n - 1
    min_idx = n
    while l <= r:
        m = (l + r) // 2
        if arr[m] > x:
            min_idx = min(min_idx, m)
            r = m - 1
        else:
            l = m + 1
    return min_idx

for _ in range(m):
    x = int(input())
    lower = lower_bound(x)
    upper = upper_bound(x)
    print(upper - lower)