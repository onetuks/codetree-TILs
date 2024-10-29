import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    private static int n;
    private static int t;
    private static int[] durs;

    public static void main(String[] args) {
        n = sc.nextInt();
        t = sc.nextInt();

        durs = new int[n];
        for (int i = 0; i < n; i ++) {
            durs[i] = sc.nextInt();
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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int d: durs) {
            if (pq.size() < k) {
                pq.add(d);
            } else {
                pq.add(pq.poll() + d);
            }
        }
        int endTime = 0;
        while (!pq.isEmpty()) {
            endTime = pq.poll();
        }
        return endTime <= t;
    }
}