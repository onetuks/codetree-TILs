n = int(input())
trains = [list(map(int, input().split())) for _ in range(n)]
trains.sort()

cnt = 0
min_vel = trains[-1][-1]

for i in reversed(range(n)):
    if trains[i][-1] <= min_vel:
        cnt += 1
        min_vel = trains[i][-1]

print(cnt)