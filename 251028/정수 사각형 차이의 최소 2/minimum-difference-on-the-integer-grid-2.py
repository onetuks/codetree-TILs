'''
1. 최댓값 중 최소인 값 구하기
    dp[i][j] = max(min(dp[왼쪽], dp[위쪽]), a[i][j])
2. 최솟값 중 최대인 값 구하기
    dp[i][j] = min(max(dp[왼쪽], dp[위쪽]), a[i][j])
3. 해당 두 값의 차이를 구하기
'''

ans = 0
n = int(input())
a = [list(map(int, input().split())) for _ in range(n)]
dp = [[0 for _ in range(n)] for _ in range(n)]

def init_min():
    dp[0][0] = a[0][0]

    for i in range(1, n):
        dp[0][i] = min(dp[0][i - 1], a[0][i])
        dp[i][0] = min(dp[i - 1][0], a[i][0])

def init_max():
    dp[0][0] = a[0][0]

    for i in range(1, n):
        dp[0][i] = max(dp[0][i - 1], a[0][i])
        dp[i][0] = max(dp[i - 1][0], a[i][0])

def cal_min():
    init_min()

    for i in range(1, n):
        for j in range(1, n):
            dp[i][j] = min(max(dp[i][j - 1], dp[i - 1][j]), a[i][j])

    return dp[-1][-1]

def cal_max():
    init_max()

    for i in range(1, n):
        for j in range(1, n):
            dp[i][j] = max(min(dp[i][j - 1], dp[i - 1][j]), a[i][j])

    return dp[-1][-1]

print(cal_max() - cal_min())
