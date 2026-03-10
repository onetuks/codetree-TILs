arr = input()

ans = 1e9

def encode(arr):
    encoded = []
    cnt, val = 0, arr[0]
    for a in arr:
        if a == val:
            cnt += 1
        else:
            encoded.append(val)
            encoded.append(str(cnt))
            # encoded.append(val + cnt)
            val = a
            cnt = 1
    if cnt > 0:
        encoded.append(val + str(cnt))
    return ''.join(encoded)

def shift(arr):
    return arr[-1] + arr[:-1]

for _ in range(len(arr)):
    encoded = encode(arr)
    ans = min(ans, len(encoded))
    arr = shift(arr)

print(ans)
