'''
dp[i][j] = max(self, dp[k][l] + 1) (1 < k < i, 1 < l < j)

# 에러케이스
## 1..n 구간을 탐색하는 경우
- (1, 1) 출발 보장 불가
- 항상 우하단 1칸 이상이면서 (1, 1) 출발이므로
- 1열1행의 DP값을 모두 구해둔 뒤, 2열2행부터 DP 구하는 수식따라 진행
'''

n, m = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]
dp = [[1 for _ in range(n)] for _ in range(n)]

for i in range(1, n):
    # 1행 구하기
    dp[i][1] = 2 if matrix[i][1] > matrix[0][0] else 0
    # 1열 구하기
    dp[1][i] = 2 if matrix[1][i] > matrix[0][0] else 0

for i in range(2, n):
    for j in range(2, n):
        for k in range(1, i):
            for l in range(1, j):
                if matrix[i][j] > matrix[k][l]:
                    dp[i][j] = max(dp[i][j], dp[k][l] + 1)

print(max([max(d) for d in dp]))