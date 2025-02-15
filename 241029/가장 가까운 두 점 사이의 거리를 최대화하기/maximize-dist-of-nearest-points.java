import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    private static int n;
    private static int[][] lines;

    public static void main(String[] args) {
        n = sc.nextInt();

        lines = new int[n][2];
        for (int i = 0; i < n; i ++) {
            lines[i][0] = sc.nextInt();
            lines[i][1] = sc.nextInt();
        }

        Arrays.sort(lines, (a, b) -> Integer.compare(a[0], b[0]));

        int l = 0, r = (int) 1e9;
        int ans = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (isPossible(m)) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean isPossible(int dist) {
        int curr = lines[0][0];
        for (int i = 1; i < n; i ++) {
            int s = lines[i][0];
            int e = lines[i][1];
            if (e < curr + dist) {
                return false;
            }
            curr = Math.max(curr + dist, s);
        }
        return true;
    }
}