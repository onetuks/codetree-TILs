'''
dp[i]: i번째 선분을 골랐을때 최대 선분 수
dp[i] = max(dp[i], dp[j] + 1 if j 끝점이 i 시작점보다 왼쪽일때 else 0) 
'''

n = int(input())
lines = [tuple(map(int, input().split())) for _ in range(n)]
dp = [1] * n

lines.sort(lambda x: x[1])

for i in range(n):
    for j in range(i):
        dp[i] = max(dp[i], dp[j] + (1 if lines[j][1] < lines[i][0] else 0))

print(max(dp))
            