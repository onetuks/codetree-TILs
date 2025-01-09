import java.util.*;
import java.io.*;

public class Main {

    private static final int[][] dlist = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int n;
    private static int[][] matrix;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        matrix = new int[n][n];
        for (int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (i == 0) getTime(i, j, 2);
                if (i == n-1) getTime(i, j, 3);
                if (j == 0) getTime(i, j, 0);
                if (j == n-1) getTime(i, j, 1);
            }
        }
        System.out.println(answer);
    }

    private static void getTime(int x, int y, int d) {
        int time = 1;
        int di = x, dj = y;
        while (time <= n * n) {
            time++;
            int nd = -1;
            if (matrix[di][dj] == 1) {
                if (d == 2) nd = 1;
                else if (d == 1) nd = 2;
                else if (d == 3) nd = 0;
                else if (d == 0) nd = 3;
            } else if (matrix[di][dj] == 2) {
                if (d == 3) nd = 1;
                else if (d == 1) nd = 3;
                else if (d == 2) nd = 0;
                else if (d == 0) nd = 2;
            }
            if (nd != -1) d = nd;
            di += dlist[d][0];
            dj += dlist[d][1];

            // if (x == 4 && y == 0)
            //     System.out.println(di + " " + dj + " " + d + " " + time);

            if (di < 0 || di >= n || dj < 0 || dj >= n) break;
        }

        answer = Math.max(answer, time);
    }
}