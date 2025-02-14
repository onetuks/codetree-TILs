import java.util.*;
import java.io.*;

public class Main { 

    private static final int[][] DLIST = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    private static int n;
    private static int[][] matrix;
    private static boolean[][] visited;

    private static int villageCnt = 0;
    private static List<Integer> populations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        matrix = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                matrix[i][j] = sc.nextInt();

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    villageCnt++;
                    visited[i][j] = true;
                    int cnt = dfs(i, j);
                    populations.add(cnt);
                }
            }
        }

        populations.sort((a, b) -> a - b);
        System.out.println(villageCnt);
        for (int population: populations)
            System.out.println(population);
    }

    private static int dfs(int i, int j) {
        int cnt = 1;
        for (int[] d: DLIST) {
            int di = i + d[0];
            int dj = j + d[1];
            if (di < 0 || di >= n || dj < 0 || dj >= n) continue;
            if (visited[di][dj] || matrix[di][dj] == 0) continue;
            visited[di][dj] = true;
            cnt += dfs(di, dj);
        }
        return cnt;
    }
}