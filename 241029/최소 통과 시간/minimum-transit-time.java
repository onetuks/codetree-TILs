import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    private static int n, m;
    private static int[] times;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();

        times = new int[m];
        for (int i = 0; i < m; i ++) {
            times[i] = sc.nextInt();
        }

        long l = 0, r = (long) Math.pow(10, 14);
        long ans = r + 1;
        while (l <= r) {
            long mid = (l + r) / 2;
            long cnt = passableCnt(mid);
            // System.out.printf("l, r, mid, cnt: %d %d %d %d\n", l, r, mid, cnt);
            if (cnt >= n) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(ans);
    }

    private static long passableCnt(long mid) {
        long cnt = 0;
        for (int time: times) {
            cnt += mid / time;
        }
        return cnt;
    }
}