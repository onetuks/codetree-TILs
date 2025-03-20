import java.util.*;


public class Main {

    private static final int EXCEPT = -1;
    private static final int BLANK = 0;
    private static final int WALL = 1;
    private static final int HUMAN = 2;
    private static final int SHELTER = 3;
    private static final int[][] DIRECTION = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static int n, h, m;
    private static int[][] matrix;
    private static int[][] dp;
    private static int[][] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();
        
        matrix = new int[n][n];
        dp = new int[n][n];
        answer = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == HUMAN) {
                    answer[i][j] = bfs(i, j);
                }
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void initDP() {
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    private static int bfs(int i, int j) {
        initDP();
        dp[i][j] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{dp[i][j], i, j});
        
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            
            if (matrix[node[1]][node[2]] == SHELTER) {
                return node[0];
            }

            for (int[] d: DIRECTION) {
                int di = node[1] + d[0];
                int dj = node[2] + d[1];
                if (di < 0 || di >= n || dj < 0 || dj >= n) continue;
                if (matrix[di][dj] == WALL) continue;
                if (dp[di][dj] <= dp[node[1]][node[2]] + 1) continue;
                dp[di][dj] = dp[node[1]][node[2]] + 1;
                pq.add(new int[]{dp[di][dj], di, dj});
            }
        }

        return EXCEPT;
    }
}