from sys import stdin

input = stdin.readline

n = int(input())
b = ["T"] + [input().strip() for _ in range(n)] + ["T"]

lh, rh = [0] * (n + 2), [0] * (n + 2)
ls, rs = [0] * (n + 2), [0] * (n + 2)
lp, rp = [0] * (n + 2), [0] * (n + 2)

for i in range(1, n+1):
    lh[i] = lh[i-1] + (1 if b[i] == "S" else 0)
    ls[i] = ls[i-1] + (1 if b[i] == "P" else 0)
    lp[i] = lp[i-1] + (1 if b[i] == "H" else 0)

for i in reversed(range(1, n+1)):
    rh[i] = rh[i+1] + (1 if b[i] == "S" else 0)
    rs[i] = rs[i+1] + (1 if b[i] == "P" else 0)
    rp[i] = rp[i+1] + (1 if b[i] == "H" else 0)

# print(lh)
# print(ls)
# print(lp)
# print(rh)
# print(rs)
# print(rp)

ans = 0
for i in range(2, n+1):
    # print("hs", lh[i-1], rs[i], lh[i-1] + rs[i])
    # print("hp", lh[i-1], rp[i], lh[i-1] + rp[i])
    # print("sh", ls[i-1], rh[i], ls[i-1] + rh[i])
    # print("sp", ls[i-1], rp[i], ls[i-1] + rp[i])
    # print("ph", lp[i-1], rh[i], lp[i-1] + rh[i])
    # print("ps", lp[i-1], rs[i], lp[i-1] + rs[i])
    cnt = max(
        lh[i-1] + rs[i], lh[i-1] + rp[i],
        ls[i-1] + rh[i], ls[i-1] + rp[i],
        lp[i-1] + rh[i], lp[i-1] + rs[i]
    )
    # print(i, cnt)
    ans = max(ans, cnt)

print(ans)