n = int(input())
init = input().strip()
target = input().strip()

ans = 0
is_diff = False

for i in range(n):
    if init[i] != target[i]:
        is_diff = True
    else:
        if is_diff:
            is_diff = False
            ans += 1

print(ans)