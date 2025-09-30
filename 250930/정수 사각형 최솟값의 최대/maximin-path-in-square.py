n = int(input())
a = [
    list(map(int, input().split()))
    for _ in range(n)
]
dp = [
    [0 for _ in range(n)]
    for _ in range(n)
]

def init():
    dp[0][0] = a[0][0]

    for j in range(1, n):
        dp[0][j] = min(dp[0][j-1], a[0][j])

    for i in range(1, n):
        dp[i][0] = min(dp[i-1][0], a[i][0])

    
init()

'''
최솟값의 최댓갑
dp[i][j]: (i, j) 지점에서의 최솟값의 최댓값
-> min(이전 경로까지의 최댓값, 현재 값)
-> min(max(왼쪽, 위쪽), 현재값))
'''
for i in range(1, n):
    for j in range(1, n):
        dp[i][j] = min(max(dp[i-1][j], dp[i][j-1]), a[i][j])

print(dp[-1][-1])
