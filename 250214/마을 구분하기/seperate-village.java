import java.util.*;
import java.io.*;

public class Main { 

    private static final int[][] DLIST = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    private static int n;
    private static int[][] matrix;
    private static boolean[][] visited;
    private static int villageCnt;
    private static List<Integer> populations = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        matrix = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j ++)
                matrix[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    visited[i][j] = true;
                    villageCnt = 1;
                    dfs(i, j);
                    populations.add(villageCnt);
                }
            }
        }

        Collections.sort(populations);
        System.out.println(populations.size());
        for (int population: populations)
            System.out.println(population);
    }

    private static void dfs(int i, int j) {
        for (int[] d: DLIST) {
            int di = i + d[0];
            int dj = j + d[1];
            if (di < 0 || di >= n || dj < 0 || dj >= n) continue;
            if (visited[di][dj] || matrix[di][dj] == 0) continue;
            visited[di][dj] = true;
            villageCnt++;
            dfs(di, dj);
        }
    }
}