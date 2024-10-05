n = int(input())
aset = set(map(int, input().split()))
m = int(input())
blist = list(map(int, input().split()))

for b in blist:
    if b in aset:
        print(1, end=" ")
    else:
        print(0, end=" ")