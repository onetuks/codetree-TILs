def type1(num):
    for i in range(num // 2 + 1):
        print("*" * (i + 1))
    for i in range(num // 2):
        print("*" * (num // 2 - i))

def type2(num):
    for i in range(num // 2 + 1):
        print(" " * (num // 2 - i), end="")
        print("*" * (i + 1))
    for i in range(num // 2):
        print(" " * (i + 1), end="")
        print("*" * (num // 2 - i))

def type3(num):
    for i in range(num // 2 + 1):
        print(" " * i, end="")
        print("*" * (num - 2 * i))
    for i in range(num // 2):
        print(" " * (num // 2 - i - 1), end="")
        print("*" * (2 * i + 3))

def type4(num):
    for i in range(num // 2 + 1):
        print(" " * i, end="")
        print("*" * (num // 2 + 1 - i))
    for i in range(num // 2):
        print(" " * (num // 2), end="")
        print("*" * (i + 2))

def main():
    n, m = map(int, input().split())

    if m == 1:
        type1(n)
    elif m == 2:
        type2(n)
    elif m == 3:
        type3(n)
    else:
        type4(n)


main()