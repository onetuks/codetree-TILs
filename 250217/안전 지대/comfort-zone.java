import java.util.*;
import java.io.*;

public class Main {

    private static final int[][] DLIST = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private static int n, m;
    private static int[][] matrix;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxCount = -1;
        int answer = 0;

        n = sc.nextInt();
        m = sc.nextInt();

        matrix = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matrix[i][j] = sc.nextInt();

        for (int k = 100; k > 0; k--) {
            visited = new boolean[n][m];
            int count = getRegionCount(k);
            if (count > maxCount) {
                maxCount = count;
                answer = k;
            }
        }

        System.out.println(answer + " " + maxCount);
    }

    private static int getRegionCount(int k) {
        int count = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || matrix[i][j] <= k) continue;
                count++;
                dfs(i, j, k);
            }
        }
        return count;
    }

    private static void dfs(int i, int j, int k) {
        for (int[] d: DLIST) {
            int di = i + d[0];
            int dj = j + d[1];
            if (di < 0 || di >= n || dj < 0 || dj >= m) continue;
            if (visited[di][dj] || matrix[di][dj] <= k) continue;
            visited[di][dj] = true;
            dfs(di, dj, k);
        }
    }
}