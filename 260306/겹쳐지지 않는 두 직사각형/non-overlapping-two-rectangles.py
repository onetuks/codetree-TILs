n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

ans = -1e9

def overlapped(pos1, pos2):
    visited = [[False for _ in range(n)] for _ in range(n)]
    si, sj = pos1[0]
    ei, ej = pos1[1]
    for i in range(si, ei):
        for j in range(sj, ej):
            visited[i][j] = True
    si, sj = pos2[0]
    ei, ej = pos2[1]
    for i in range(si, ei):
        for j in range(sj, ej):
            if visited[i][j]:
                return True
    return False

def get_sum(pos):
    si, sj = pos[0]
    ei, ej = pos[1]
    sumof = 0
    for i in range(si, ei):
        for j in range(sj, ej):
            sumof += grid[i][j]
    return sumof

for si1 in range(n):
    for sj1 in range(n):
        for ei1 in range(si1 + 1, n + 1):
            for ej1 in range(sj1 + 1, n + 1):
                pos1 = [(si1, sj1), (ei1, ej1)]
                for si2 in range(n):
                    for sj2 in range(n):
                        for ei2 in range(si2 + 1, n + 1):
                            for ej2 in range(sj2 + 1, n + 1):
                                pos2 = [(si2, sj2), (ei2, ej2)]
                                if overlapped(pos1, pos2):
                                    continue
                                sumof1 = get_sum(pos1)
                                sumof2 = get_sum(pos2)
                                sumof = sumof1 + sumof2
                                ans = max(ans, sumof)

print(ans)

