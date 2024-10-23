import java.util.*;

public class Main {

    private static int n;
    private static PriorityQueue<int[]> pq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int i = 0; i < n; i ++) {
            int x = sc.nextInt();

            if (x != 0) {
                pq.add(new int[]{Math.abs(x), x});
            } else {
                if (pq.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                int[] v = pq.poll();
                System.out.println(v[1]);
            }
        }
    }
}