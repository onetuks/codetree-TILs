n = int(input())
word = input()

c_cnt = [0] * n
w_cnt = [0] * n

if word[0] == "C":
    c_cnt[0] = 1
if word[-1] == "W":
    w_cnt[-1] = 1

for i in range(1, n):
    c_cnt[i] = c_cnt[i-1] + (1 if word[i] == "C" else 0)

for i in reversed(range(n-1)):
    w_cnt[i] = w_cnt[i+1] + (1 if word[i] == "W" else 0)

ans = 0
for i in range(1, n-1):
    if word[i] == "O":
        ans += c_cnt[i-1] * w_cnt[i+1]

print(ans)