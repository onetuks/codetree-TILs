n = int(input())
prices = list(map(int, input().split()))

min_price = prices[0]
ans = 0

for price in prices:
    ans = max(ans, price - min_price)
    min_price = min(min_price, price)

print(ans)