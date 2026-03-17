DLIST = [[-1, 0], [1, 0], [0, -1], [0, 1]]

n, m, t = map(int, input().split())

# Create n x n grid
grid = [list(map(int, input().split())) for _ in range(n)]

# Get m marble positions
marbles = [tuple(map(int, input().split())) for _ in range(m)]
marbles = [(r - 1, c - 1) for r, c in marbles]

def in_range(i, j):
    return 0 <= i < n and 0 <= j < n

def move(loc):
    i, j = loc
    ti, tj = i, j
    val = 0
    for dx, dy in DLIST:
        di, dj = i + dx, j + dy
        if not in_range(di, dj):
            continue
        if val < grid[di][dj]:
            val = grid[di][dj]
            ti, tj = di, dj
    return (ti, tj)

for _ in range(t):
    next_marbles = {}
    for marble in marbles:
        new_marble = move(marble)
        next_marbles[new_marble] = next_marbles.get(new_marble, 0) + 1
    # print(next_marbles)
    temp_marbles = []
    for key, val in next_marbles.items():
        if val <= 1:
            temp_marbles.append(key)
    marbles = temp_marbles

print(len(marbles))
