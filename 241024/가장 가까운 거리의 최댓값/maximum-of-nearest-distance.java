import java.util.*;

class Pair implements Comparable<Pair> {
    int cost;
    int node;

    Pair(int cost, int node) {
        this.cost = cost;
        this.node = node;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.cost == o.cost) {
            return this.node - o.node;
        }
        return this.cost - o.cost;
    }
}

public class Main {
    private static Scanner sc = new Scanner(System.in);

    private static int n;
    private static int m;

    private static int[] inits;
    private static int[][] dp;
    private static int[][] adj;

    public static void main(String[] args) {
        int ans = 0;

        n = sc.nextInt();
        m = sc.nextInt();

        inits = new int[3];
        dp = new int[3][n + 1];
        for (int i = 0; i < 3; i ++) {
            inits[i] = sc.nextInt();
            for (int j = 0; j <= n; j ++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
            dp[i][inits[i]] = 0;
        }

        adj = new int[n + 1][n + 1];

        for (int i = 0; i < m; i ++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adj[u][v] = w;
            adj[v][u] = w;
        }

        for (int i = 0; i < 3; i ++) {
            dijkstra(i);
        }

        for (int i = 1; i <= n; i ++) {
            int minDist = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j ++) {
                minDist = Math.min(dp[j][i], minDist);
            }
            ans = Math.max(ans, minDist);
        }

        System.out.println(ans);
    }

    private static void dijkstra(int index) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int init = inits[index];
        pq.add(new Pair(dp[index][init], init));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            
            if (dp[index][pair.node] < pair.cost) {
                continue;
            }

            for (int nextNode = 1; nextNode <= n; nextNode ++) {
                if (adj[pair.node][nextNode] == 0) {
                    continue;
                }
                if (dp[index][nextNode] > dp[index][pair.node] + adj[pair.node][nextNode]) {
                    dp[index][nextNode] = dp[index][pair.node] + adj[pair.node][nextNode];
                    pq.add(new Pair(dp[index][nextNode], nextNode));
                }
            }
        }
    }
}