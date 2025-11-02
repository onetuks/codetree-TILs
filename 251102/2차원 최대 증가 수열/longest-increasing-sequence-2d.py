'''
dp[i][j] = max(dp[i][j], dp[i-k][j-l] + 1) (0 < k < i, 0 < l < j)

# 주의점
- dp 초기값은 0 이어선 안됨
- 모든 DP값이 동일한 경우 (1, 1) 출발을 보장할 수 없기 때문
- DP[1][1]에 가중치를 둘 수 있도록 해야함
- DP[1][1] 만 0으로 두고, 나머지는 주어지는 수 만큼 크게 만들어서 하면 어떨까
'''

INIT = int(1e4)

n, m = map(int, input().split())
matrix = [
    [0 for _ in range(m + 1)]
    for _ in range(n + 1)
]
dp = [
    [0 for _ in range(m + 1)]
    for _ in range(n + 1)
]
dp[0][0] = INIT

for i in range(1, n + 1):
    nums = list(map(int, input().split()))
    for j in range(m):
        matrix[i][j + 1] = nums[j]

for i in range(1, n + 1):
    for j in range(1, m + 1):
        for k in range(i):
            for l in range(j):
                if matrix[i][j] > matrix[k][l]:
                    dp[i][j] = max(dp[i][j], dp[k][l] + 1)

print(max(list(max(d) for d in dp)) - INIT)
