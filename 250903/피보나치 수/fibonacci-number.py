n = int(input())

def fib(num, dp):
    if num <= 2:
        dp[num] = 1
        return dp[num]
    elif dp[num]:
        return dp[num]
    dp[num] = fib(num - 1, dp) + fib(num - 2, dp)
    return dp[num]

def memoization():
    dp = [0 for _ in range(n+1)]
    ans = fib(n, dp)
    print(ans)

def tabulation():
    dp = [1 for _ in range(n+1)]
    for i in range(3, n+1):
        dp[i] = dp[i - 1] + dp[i - 2]
    print(dp[n])

# memoization()
tabulation()