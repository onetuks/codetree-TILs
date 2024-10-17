n = int(input())
# (개수, 숫자)
nums = [tuple(map(int, input().split())) for _ in range(n)]
nums.sort(key=lambda x: x[1])

ans = 1e11
i, j = 0, n - 1
while i <= j:
    ci, ni = nums[i]
    cj, nj = nums[j]

    ans = min(ans, ni + nj)

    if ci < cj:
        nums[j] = (cj - ci, nj)
        i += 1
    elif ci > cj:
        nums[i] = (ci - cj, ni)
        j -= 1
    else:
        i += 1
        j -= 1

print(ans)