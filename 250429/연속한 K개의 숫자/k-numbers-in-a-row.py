n, k, b = tuple(map(int, input().split()))
arr = [0] * (n + 1)
psum = [0] * (n + 1)


def get_sum(s, e):
    return psum[e] - psum[s - 1]
    

def main():
    for _ in range(b):
        x = int(input())
        arr[x] = 1
    
    for i in range(1, n + 1):
        psum[i] = psum[i - 1] + arr[i]

    ans = 1e9

    for i in range(1, n - k + 2):
        j = i + k - 1
        ans = min(ans, get_sum(i, j))

    print(ans)


main()