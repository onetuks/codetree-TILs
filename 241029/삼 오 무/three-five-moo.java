import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    private static int n;

    public static void main(String[] args) {
        n = sc.nextInt();

        long l = 1, r = (long) Math.pow(10, 10);
        long ans = r + 1;
        while (l <= r) {
            long m = (l + r) / 2;
            if (getDigitCount(m) >= n) {
                ans = Math.min(ans, m);
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        System.out.println(ans);
    }

    private static long getDigitCount(long num) {
        long mooCount = num / 3 + num / 5 - num / 15;
        return num - mooCount;
    }
}