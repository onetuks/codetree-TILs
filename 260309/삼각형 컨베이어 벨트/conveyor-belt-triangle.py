n, t = map(int, input().split())

l = list(map(int, input().split()))
r = list(map(int, input().split()))
d = list(map(int, input().split()))

for _ in range(t):
    l_temp = l[-1]
    r_temp = r[-1]
    d_temp = d[-1]

    for i in reversed(range(1, n)):
        l[i] = l[i - 1]
        r[i] = r[i - 1]
        d[i] = d[i - 1]

    l[0] = d_temp
    r[0] = l_temp
    d[0] = r_temp

def print_line(lst):
    for l in lst:
        print(l, end = " ")
    print()

print_line(l)
print_line(r)
print_line(d)
