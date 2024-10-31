import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    private static int[][] dlist = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int n;
    private static int target;
    private static int[][] matrix;
    private static boolean[][] visited;
    
    public static void main(String[] args) {
        n = sc.nextInt();
        target = (int) Math.ceil(n * n / 2.0);

        matrix = new int[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++)
                matrix[i][j] = sc.nextInt();
        }

        int l = 0, r = (int) 1e6;
        int ans = r + 1;
        while (l <= r) {
            int m = (l + r) / 2;
            // System.out.printf("l, r, p: %d %d %b\n", l, r, isPossible(m));
            if (isPossible(m)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean isPossible(int diff) {
        int maxCount = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    int count = dfs(i, j, diff);
                    maxCount = Math.max(maxCount, count);
                    // System.out.printf("i, j, count, maxCount: %d %d %d %d\n", i, j, count, maxCount);
                    if (maxCount >= target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static int dfs(int i, int j, int diff) {
        int count = 1;
        for (int[] d: dlist) {
            int di = i + d[0], dj = j + d[1];
            if (di < 0 || di >= n || dj < 0 || dj >= n) continue;
            if (Math.abs(matrix[i][j] - matrix[di][dj]) <= diff && !visited[di][dj]) {
                visited[di][dj] = true;
                count += dfs(di, dj, diff);
            }
        }
        return count;
    }
}