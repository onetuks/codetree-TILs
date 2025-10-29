'''
※ 최대-최소 값을 인덱스마다 구하는 방식으로는 다음값을 예측할 수 없음
   -> 해당 인덱스에서 참고할 최댓값, 최솟값이 같은 경로에서 온 것인지 확정할 수 없기 때문

1. 최솟값 고정하기 [1..n] -> 범위가 O(10^2)로 매우 작기 때문
2. 최댓값 중 최소인 값 구하기 -> 최솟값 기준보다 작은 경우에는 탐색하지 않아야 함(그래야 최댓값의 최솟값을 구할 수 있음)
3. 그 차이가 최소인 값 구해서 출력하기
'''

INIT_VAL = 1e9

ans = INIT_VAL

n = int(input())
a = [list(map(int, input().split())) for _ in range(n)]
dp = [[INIT_VAL for _ in range(n)] for _ in range(n)]

def init():
    for i in range(n):
        for j in range(n):
            dp[i][j] = INIT_VAL

    dp[0][0] = a[0][0]

    for i in range(1, n):
        dp[0][i] = max(dp[0][i-1], a[0][i])
        dp[i][0] = max(dp[i-1][0], a[i][0])

def solve(lower_bound):
    for i in range(n): 
        for j in range(n):
            if a[i][j] < lower_bound:
                a[i][j] = INIT_VAL

    init()

    for i in range(1, n):
        for j in range(1, n):
            dp[i][j] = max(min(dp[i-1][j], dp[i][j-1]), a[i][j])

    return dp[-1][-1]

for lower_bound in range(1, 101):
    upper_bound = solve(lower_bound)
    if upper_bound == INIT_VAL:
        continue
    ans = min(ans, upper_bound - lower_bound)

print(ans)