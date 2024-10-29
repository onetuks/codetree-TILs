import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    private static int n;
    private static int t;
    private static int durs = 0;

    public static void main(String[] args) {
        n = sc.nextInt();
        t = sc.nextInt();

        for (int i = 0; i < n; i ++) {
            durs += sc.nextInt();
        }

        int l = 1, r = n;
        int ans = n;
        while (l <= r) {
            int m = (l + r) / 2;
            if (isPossible(m)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean isPossible(int k) {
        return durs / (float) k <= t;
    }
}