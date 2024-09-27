n = int(input())

nums = list(map(int, input().split()))

acc_sum = 0

for num in nums:
    acc_sum += num 
    if num >= 100:
        break

print(acc_sum)
print(round(acc_sum / n, 1))