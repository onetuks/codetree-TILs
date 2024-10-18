n = int(input())
init = list(input().strip())
target = list(input().strip())

ans = 0

for i in reversed(range(n)):
    if init[i] != target[i]:
        ans += 1
        for j in range(i + 1):
            init[j] = 'G' if init[j] == 'H' else 'H'

print(ans)