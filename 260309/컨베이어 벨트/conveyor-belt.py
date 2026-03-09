n, t = map(int, input().split())
u = list(map(int, input().split()))
d = list(map(int, input().split()))

for _ in range(t):
    u_temp = u[-1]
    d_temp = d[-1]
    
    for i in reversed(range(1, n)):
        u[i] = u[i - 1]
    for i in reversed(range(1, n)):
        d[i] = d[i - 1]

    u[0] = d_temp
    d[0] = u_temp

def print_belt(lst):
    for l in lst:
        print(l, end = " ") 
    
print_belt(u)
print()
print_belt(d)