n = int(input())
aset = set(map(int, input().split()))
m = int(input())
blist = list(map(int, input().split()))

for b in blist:
    print(1 if b in aset else 0)