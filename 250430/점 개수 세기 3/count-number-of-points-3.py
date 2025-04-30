from sortedcontainers import SortedSet

# 변수 선언 및 입력:
n, q = tuple(map(int, input().split()))
arr = list(map(int, input().split()))
queries = [
    tuple(map(int, input().split()))
    for _ in range(q)
]

# 주어진 x좌표값들을 전부 treeset에 넣어줍니다.
nums = SortedSet(arr)

# treeset에서 정점을 작은 번호부터 뽑으면서
# 각 정점별로 1번부터 순서대로 매칭하여
# 그 결과를 hashmap에 넣어줍니다.
mapper = dict()
cnt = 1
for num in nums:
    mapper[num] = cnt
    cnt += 1
    
for a, b in queries:
    print(mapper[b] - mapper[a] + 1)