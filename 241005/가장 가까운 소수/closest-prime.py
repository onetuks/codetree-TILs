import sys
import math

input = sys.stdin.readline

def is_prime(num):
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    return True

n = int(input())

for i in range(1, int(1e6) + 1):
    if n - i < 1 and n + i > int(1e6):
        break
    if n - i >= 1 and is_prime(n - i):
        print(n - i)
        break
    elif n + i <= int(1e6) and is_prime(n + i):
        print(n + i)
        break