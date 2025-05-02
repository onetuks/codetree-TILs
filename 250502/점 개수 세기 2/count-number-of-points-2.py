from sortedcontainers import SortedSet

n, q = map(int, input().split())
nums = SortedSet()
mapper = dict()

points = [tuple(map(int, input().split())) for _ in range(n)]
queries = [tuple(map(int, input().split())) for _ in range(q)]

def get_lower_bound(num):
    return nums.bisect_left(num) + 1

def get_upper_bound(num):
    return nums.bisect_right(num)

for x, y in points:
    nums.add(x)
    nums.add(y)

cnt = 1
for num in nums:
    mapper[num] = cnt
    cnt += 1

psum = [[0 for _ in range(5002)] for _ in range(5002)]
for x, y in points:
    psum[mapper[x]][mapper[y]] += 1

for i in range(1, cnt+1):
    for j in range(1, cnt+1):
        psum[i][j] += psum[i-1][j] + psum[i][j-1] - psum[i-1][j-1]

for r, c, x, y in queries:
    nr = get_lower_bound(r)
    nc = get_lower_bound(c)
    nx = get_upper_bound(x)
    ny = get_upper_bound(y)
    ans = psum[nx][ny] - psum[nx][nc-1] - psum[nr-1][ny] + psum[nr-1][nc-1]
    print(ans)
