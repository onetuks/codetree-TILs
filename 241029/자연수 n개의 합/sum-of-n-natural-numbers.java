import java.util.*;

public class Main {
    
    private static Scanner sc = new Scanner(System.in);

    private static long s;

    public static void main(String[] args) {
        s = sc.nextLong();

        long l = 1, r = (long) Math.pow(10, 9);
        long n = r + 1;
        while (l <= r) {
            long m = (l + r) / 2;
            if (m * (m + 1) / 2 <= s) {
                n = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        System.out.println(n);
    }
}