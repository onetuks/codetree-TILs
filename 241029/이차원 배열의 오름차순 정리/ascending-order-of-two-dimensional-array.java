import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    private static long n;
    private static long k;
    
    public static void main(String[] args) {
        n = sc.nextLong();
        k = sc.nextLong();

        long l = 1, r = n * n;
        long ans = r + 1;
        while (l <= r) {
            long m = (l + r) / 2;
            
            long count = 0;
            for (long i = 1; i <= n; i ++) {
                count += Math.min(n, m / i);
            }

            if (count >= k) {
                ans = Math.min(ans, m);
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        System.out.println(ans);
    }
}