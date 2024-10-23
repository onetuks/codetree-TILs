import java.util.*;

class Bomb implements Comparable<Bomb> {
    int timeLimit;
    int score;

    Bomb(int timeLimit, int score) {
        this.timeLimit = timeLimit;
        this.score = score;
    }

    @Override
    public int compareTo(Bomb o) {
        if (this.timeLimit == o.timeLimit) 
            return this.score - o.score;
        return this.timeLimit - o.timeLimit;
    }
}

public class Main {
    
    private static Scanner sc = new Scanner(System.in);
    private static int n;
    private static List<Bomb> bombs = new ArrayList<>();

    public static void main(String[] args) {
        int ans = 0;

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            int timeLimit = sc.nextInt();
            bombs.add(new Bomb(timeLimit, score));
        }

        Collections.sort(bombs);

        int idx = n - 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int time = bombs.get(idx).timeLimit; time > 0; time--) {
            while (idx >= 0 && time <= bombs.get(idx).timeLimit) {
                pq.add(bombs.get(idx).score);
                idx--;
            }

            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }

        System.out.println(ans);
    }
}