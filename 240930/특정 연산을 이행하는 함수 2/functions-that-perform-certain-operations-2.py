from math import ceil, floor

alist = sorted(list(map(float, input().split())))

print(ceil(alist[-1]), floor(alist[0]), round(alist[1]))