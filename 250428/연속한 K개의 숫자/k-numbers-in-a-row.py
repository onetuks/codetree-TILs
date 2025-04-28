missing = []
k = 0

def get_cnt(idx):
    global k
    cnt = 0
    for m in missing:
        if idx <= m < idx + k:
            cnt += 1
    return cnt

def main():
    global k, missing
    n, k, b = map(int, input().split())
    missing = [int(input()) for _ in range(b)]
    ans = 1e9
    psum = [0]
    s = 0
    for i in range(1, n + 1):
        if i not in missing:
            s += i
        psum.append(s)

    min_diff = 1e9
    for i in range(n - k + 1):
        j = i + k
        real = psum[j] - psum[i]
        expt = (j + i + 1) * k / 2
        # 차이가 같은 구간이 여러개인 경우 없는 번호가 제일 적은 것으로 골라야 함
        # print(i + 1, j, real, expt, expt - real, min_diff)
        if expt - real <= min_diff:
            min_diff = expt - real
            cnt = get_cnt(i + 1)
            ans = min(ans, cnt)
        
    print(ans)


main()