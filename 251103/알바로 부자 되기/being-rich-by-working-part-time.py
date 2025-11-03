'''
dp[i]: i번 알바를 선택한 경우 최대로 얻는 액수
dp[i] = max(self, dp[j] + (p[i] if j랑 안겹치면 else 0))

# 안 겹치는 조건
- j의 끝나는 시간 > i의 시작하는 시간 (e[j] < s[i])
'''

from copy import deepcopy

n = int(input())
jobs = [tuple(map(int, input().split())) for _ in range(n)]
s = [job[0] for job in jobs]
e = [job[1] for job in jobs]
p = [job[2] for job in jobs]

dp = deepcopy(p)

for i in range(n):
    for j in range(i):
        if e[j] < s[i]:
            dp[i] = max(dp[i], dp[j] + p[i])
        # else:
        #     dp[i] = max(dp[i], dp[j])

print(max(dp))

# print(dp)
