import sys
import math

input = sys.stdin.readline

def is_prime(num):
    if num <= 1:
        return False
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    return True

n = int(input())

for i in range(1, int(1e6) + 1):
    a, b = n - i, n + i
    
    a_prime = is_prime(a)
    b_prime = is_prime(b)

    if a_prime:
        print(a, end=" ")
    if b_prime:
        print(b)
    
    if a_prime or b_prime:
        break