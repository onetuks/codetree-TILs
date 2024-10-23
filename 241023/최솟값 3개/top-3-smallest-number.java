import java.util.*;

public class Main {
    private static int n;
    private static PriorityQueue<Integer> pq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        
        pq = new PriorityQueue<>((a, b) -> a - b);

        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());

            if (pq.size() >= 3) {
                int x = pq.poll();
                int y = pq.poll();
                int z = pq.poll();

                pq.add(x);
                pq.add(y);
                pq.add(z);

                System.out.println(x * y * z);
            } else {
                System.out.println(-1);
            }
        }
    }
}