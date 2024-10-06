n, g = map(int, input().split())

invited = set([1])

for _ in range(g):
    line = list(map(int, input().split()))

    group = set(line[1:])
    rest = group - invited
    
    if len(rest) <= 1:
        invited |= group

print(len(invited))