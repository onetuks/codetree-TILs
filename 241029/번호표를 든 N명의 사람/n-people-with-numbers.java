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
        int idx = 0;
        int totalTime = 0;
        while (!pq.isEmpty() || idx < n) {
            while (idx < n && pq.size() < k) {
                pq.add(durs[idx]);
                idx ++;
            }

            PriorityQueue<Integer> temp = new PriorityQueue<>();
            if (!pq.isEmpty()) {
                int d = pq.poll();
                totalTime += d;
                while (!pq.isEmpty()) {
                    int restTime = pq.poll() - d;
                    if (restTime > 0) 
                        temp.add(restTime);
                }
            }

            if (totalTime > t) {
                return false;
            }

            pq = temp;
        }
        return true;
    }
}