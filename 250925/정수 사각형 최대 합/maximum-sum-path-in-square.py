n = int(input())
matrix = [[0 for i in range(n + 1)] for _ in range(n + 1)]

for i in range(1, n):
    nums = list(map(int, input().split()))
    for j in range(1, n):
        matrix[i][j] = nums[j]

for mat in matrix:
    print(mat)