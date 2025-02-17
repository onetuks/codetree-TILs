import java.util.*;
import java.io.*;

public class Main {

    private static final int[][] DLIST = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private static int n;
    private static int[][] matrix;
    private static boolean[][] visited;

    private static int explodedBombCount = 0;
    private static int maxBlockSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        matrix = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        explode();

        System.out.println(explodedBombCount + " " + maxBlockSize);
    }

    private static void explode() {
        for (int i = 0; i< n; i ++) {
            for (int j = 0; j < n;j ++) {
                if (visited[i][j]) continue;
                visited[i][j] = true;
                int count = dfs(i, j);
                maxBlockSize = Math.max(maxBlockSize, count);
                if (count >= 4)
                    explodedBombCount++;
            }
        }
    }

    private static int dfs(int i, int j) {
        int cnt = 1;
        int val = matrix[i][j];
        for (int[] d: DLIST) {
            int di = i + d[0];
            int dj = j + d[1];
            if (di < 0 || di >= n || dj < 0 || dj >= n) continue;
            if (visited[di][dj] || matrix[di][dj] != val) continue;
            visited[di][dj] = true;
            cnt += dfs(di, dj);
        }
        return cnt;
    }
}