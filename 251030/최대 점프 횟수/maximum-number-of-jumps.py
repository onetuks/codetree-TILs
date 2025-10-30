'''
dp[i]: i 위치에 도달 가능한 최대 점프 수
dp[i] = max(dp[i], dp[j] + 1) (0 <= j < i; j + num[j] >= i)
'''

n = int(input())
arr = list(map(int, input().split()))
dp = [0 for _ in range(n)]
dp[0] = 1

for i in range(1, n):
    for j in range(i):
        if j + arr[j] >= i and dp[j] > 0:
            dp[i] = max(dp[i], dp[j] + 1)

print(max(dp) - 1)
# print(dp)
