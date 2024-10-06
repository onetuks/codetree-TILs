n, m = map(int, input().split())
aset = set(map(int, input().split()))
bset = set(map(int, input().split()))

symmentry = aset ^ bset

print(len(symmentry))