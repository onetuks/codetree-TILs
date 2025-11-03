'''
dp[i] = i번째 수에서의 가장 긴 증감 부분 수열 길이

- 정방향으로 LST 구하기
- 역방향으로 LST 구하기
- DP값이 최대가 되는 값 - 1 출력
'''

n = int(input())
arr = list(map(int, input().split()))

ldp = [1 for _ in range(n)]
rdp = [1 for _ in range(n)]

for i in range(n):
    for j in range(i):
        if arr[i] > arr[j]:
            ldp[i] = max(ldp[i], ldp[j] + 1)
        if arr[n - 1 - i] > arr[n - j - 1]:
            rdp[n-1-i] = max(rdp[n-1-i], rdp[n-j-1] + 1)

print(max([ldp[i] + rdp[i] for i in range(n)]) - 1)

