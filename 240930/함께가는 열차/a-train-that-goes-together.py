'''
Greedy

1. 순회하면서 속도가 점점 높은 곳을 찾기
'''

n = int(input())
trains = [list(map(int, input().split())) for _ in range(n)]

trains.sort()

cnt = 1
min_vel = trains[-1][1]

for i in range(n - 2, -1, -1):
    if trains[i][1] <= min_vel:
        min_vel = trains[i][1]
        cnt += 1

print(cnt)