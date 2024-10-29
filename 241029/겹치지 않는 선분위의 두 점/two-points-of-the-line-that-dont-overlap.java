import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    private static int n, m;
    private static long[][] lines;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();

        lines = new long[m][2];
        for (int i = 0; i < m; i ++) {
            lines[i] = new long[]{sc.nextLong(), sc.nextLong()};
        }

        Arrays.sort(lines, (a, b) -> Long.compare(a[1], b[1]));

        long l = 0, r = (long) Math.pow(10, 18);
        long ans = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            long cnt = getCnt(mid);
            if (cnt >= n) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(ans);
    }

    private static long getCnt(long dist) {
        long cnt = 1;
        long pos = lines[0][0];
        for (int i = 0; i < m; i ++) {
            long s = lines[i][0];
            long e = lines[i][1];
            for (long cur = Math.max(s, pos + dist); cur <= e; cur += dist) {
                cnt ++;
                pos = cur;
            }
        }
        return cnt;
    }
}