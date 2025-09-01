from heapq import heappush, heappop


n = int(input())

if n == 1:
    print(0)
else:
    visited = set()
    q = [(0, n)]


    def add_num(cnt, num):
        if num in visited:
            return
        visited.add(num)
        heappush(q, (cnt + 1, num))
        # print(cnt + 1, num, visited)


    def minus_one(cnt, num):
        add_num(cnt, num - 1)


    def plus_one(cnt, num):
        add_num(cnt, num + 1)


    def divide_two(cnt, num):
        if num % 2 == 0:
            add_num(cnt, num // 2)


    def divide_three(cnt, num):
        if num % 3 == 0:
            add_num(cnt, num // 3)


    while q:
        cnt, num = heappop(q)

        if num == 1:
            print(cnt)
            break

        # print(cnt, num)

        minus_one(cnt, num)
        plus_one(cnt, num)
        divide_two(cnt, num)
        divide_three(cnt, num)

