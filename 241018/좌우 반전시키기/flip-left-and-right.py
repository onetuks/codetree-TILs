n = int(input())
nums = list(map(int, input().split()))

ans = 0

def convert(i):
    nums[i] = 1
    nums[i - 1] = (nums[i - 1] + 1) % 2
    if i + 1 < n:
        nums[i + 1] = (nums[i + 1] + 1) % 2

for i in range(1, n):
    if nums[i - 1] == 0 and nums[i] == 0:
        convert(i)
        ans += 1

if 0 in nums:
    print(-1)
else:
    print(ans)