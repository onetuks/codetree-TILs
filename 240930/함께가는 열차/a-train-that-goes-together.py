n = int(input())

trains = [list(map(int, input().split())) for _ in range(n)]

parent = [i for i in range(n)]

def find(num):
    if parent[num] == num:
        return num
    return find(parent[num])


def union(a, b):
    fa, fb = find(a), find(b)
    if fa < fb:
        parent[fb] = fa
    elif fa > fb:
        parent[fa] = fb


for i in range(n - 1):
    for j in range(i + 1, n):
        if trains[i][0] == trains[j][0]:
            union(i, j)
        elif trains[i][0] < trains[j][0] and trains[i][1] > trains[j][1]:
            union(i, j)
        
answer = len(set([find(num) for num in parent]))

print(answer)