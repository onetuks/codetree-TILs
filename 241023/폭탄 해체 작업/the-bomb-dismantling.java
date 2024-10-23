import java.util.*;

public class Main {
    
    private static Scanner sc = new Scanner(System.in);
    private static int n;
    private static List<int[]> bombs = new ArrayList<>();

    public static void main(String[] args) {
        n = sc.nextInt();

        for (int i = 0; i < n; i ++) {
            int s = sc.nextInt();
            int l = sc.nextInt();
            bombs.add(new int[]{l, s});
        }

        Collections.sort(bombs, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int idx = n - 1;
        PriorityQueue<Integer> scores = new PriorityQueue<>((a, b) -> b - a);

        int ans = 0;

        for (int time = bombs.get(idx)[0]; time > 0; time--) {
            while (idx >= 0 && time <= bombs.get(idx)[0]) {
                scores.add(bombs.get(idx)[1]);
                idx--;
            }

            if (!scores.isEmpty()) {
                ans += scores.poll();
            }
        }

        System.out.println(ans);
    }
}