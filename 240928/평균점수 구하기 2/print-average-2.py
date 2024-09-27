n = int(input())
scores = list(map(float, input().split()))

answer = round(sum(scores) / n, 1)

print(answer)