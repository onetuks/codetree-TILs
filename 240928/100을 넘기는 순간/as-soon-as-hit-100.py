n = int(input())

nums = list(map(int, input().split()))

acc_sum = 0
cnt = 0

for num in nums:
    acc_sum += num 
    cnt += 1
    if num >= 100:
        break

print(acc_sum)
print(round(acc_sum / cnt, 1))