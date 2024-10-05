n, m = map(int, input().split())
w_to_n = dict()
n_to_w = dict()

for i in range(n):
    val = input()
    w_to_n[val] = i + 1
    n_to_w[i + 1] = val

for _ in range(m):
    val = input()

    if val.isdigit():
        print(n_to_w[int(val)])
    else:
        print(w_to_n[val])