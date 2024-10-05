from sortedcontainers import SortedDict

n = int(input())

words = SortedDict()

for _ in range(n):
    word = input()

    if word not in words:
        words[word] = 1
    else:
        words[word] += 1

for k, v in words.items():
    print(k, v)