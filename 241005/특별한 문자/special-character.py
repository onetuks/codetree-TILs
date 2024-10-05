from collections import Counter

word = input()

count = Counter(word)

only_one_set = [k for k, v in count.items() if v == 1]

if not only_one_set:
    print(None)
else:
    for w in word:
        if w in only_one_set:
            print(w)
            break