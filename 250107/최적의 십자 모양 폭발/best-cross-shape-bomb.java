import java.util.*;
import java.io.*;

public class Main {

    private static final int[][] dlist = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    
    private static int n;
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        setup();

        int answer = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                answer = Math.max(answer, solve(i, j));
            }
        }

        System.out.println(answer);
    }

    private static int solve(int x, int y) {
        int result = 0;
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                temp[i][j] = matrix[i][j];

        int val = matrix[x][y];

        for (int[] d: dlist) {
            int di = x, dj = y;
            for (int i = 0; i < val; i ++) {
                if (di < 0 || di >= n || dj < 0 || dj >= n) break;
                temp[di][dj] = 0;
                di += d[0];
                dj += d[1];
            }
        }

        for (int j = 0; j < n; j ++) {
            int idx = n - 1;
            for (int i = n - 1; i >= 0; i --) {
                if (temp[i][j] == 0) continue;
                temp[idx--][j] = temp[i][j];
            }
            for (int i = 0; i <= idx; i ++) {
                temp[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n - 1; j ++) {
                if (temp[i][j] == 0) continue;
                if (temp[i][j] == temp[i][j + 1]) result++;
            }
        }
        for (int j = 0; j < n; j ++) {
            for (int i = 0; i < n - 1; i ++) {
                if (temp[i][j] == 0) continue;
                if (temp[i][j] == temp[i + 1][j]) result++;
            }

        }

        return result;
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        
        matrix = new int[n][n];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}