n = int(input())
init = input().strip()
target = input().strip()

ans, cnt = 0, 0
for i in range(n):
    if init[i] != target[i]:
        cnt += 1
        if cnt >= 4:
            ans += 1
            cnt = 0
    elif init[i] == target[i] and cnt > 0:
        ans += 1
        cnt = 0

print(ans)