n, m = map(int, input().split())
numbers = [int(input()) for _ in range(n)]

def explode(arr):
    temp = []
    val, cnt = arr[0], 0
    for a in arr:
        if a == val:
            cnt += 1
            continue
        if cnt < m:
            for _ in range(cnt):
                temp.append(val)
        val = a
        cnt = 1
    if 0 < cnt < m:
        for _ in range(cnt):
            temp.append(val)
    return temp

while True:
    if len(numbers) == 0:
        break
    result = explode(numbers)
    if len(result) == len(numbers):
        break
    numbers = result

print(len(numbers))
for num in numbers:
    print(num)
