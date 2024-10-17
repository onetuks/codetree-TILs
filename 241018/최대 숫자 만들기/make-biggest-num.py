from functools import cmp_to_key

def compare(a, b):
    if a + b < b + a:
        return 1
    elif a + b > b + a:
        return -1
    return 0

n = int(input())
arr = [input().strip() for _ in range(n)]

arr.sort(key=cmp_to_key(compare))

print(''.join(arr))