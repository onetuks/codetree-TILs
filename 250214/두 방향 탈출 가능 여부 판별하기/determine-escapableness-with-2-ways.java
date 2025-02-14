import java.util.*;
import java.io.*;

public class Main {

    private static final int[][] DLIST = {{1, 0}, {0, 1}};

    private static int n, m;
    private static int[][] matrix;
    private static boolean[][] visited;
    
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0] = true;
        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int x, int y) {
        if (answer == 1) return;
        if (x == n - 1 && y == m - 1) answer = 1;
        for (int[] d: DLIST) {
            int di = x + d[0];
            int dj = y + d[1];
            if (!canGo(di, dj)) continue;
            visited[di][dj] = true;
            dfs(di, dj);
        }
    }

    private static boolean canGo(int i, int j) {
        return inRange(i, j) && matrix[i][j] == 1 && !visited[i][j];
    }

    private static boolean inRange(int i, int j) {
        return !(i < 0 || i >= n || j < 0 || j >= m);
    }
}