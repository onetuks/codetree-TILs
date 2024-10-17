from functools import cmp_to_key

def compare(a, b):
    ao, ac = a
    bo, bc = b

    if ao * bc < bo * ac:
        return 1
    elif ao * bc > bo * ac: 
        return -1
    return 0

n = int(input())
brankets = []

ans = 0

for _ in range(n):
    s = input().strip()
    open_cnt, close_cnt = 0, 0
    for c in s:
        if c == '(':
            open_cnt += 1
        elif c == ')':
            close_cnt += 1
            ans += open_cnt
    brankets.append((open_cnt, close_cnt))

brankets.sort(key=cmp_to_key(compare))

open_sum = 0
for open_cnt, close_cnt in brankets:
    ans += open_sum * close_cnt
    open_sum += open_cnt

print(ans)