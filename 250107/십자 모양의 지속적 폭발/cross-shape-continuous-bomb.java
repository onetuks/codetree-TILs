import java.util.*;
import java.io.*;

public class Main {
    
    private static final int NONE = -1;
    private static final int[][] dlist = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    private static int n, m;
    private static int[][] matrix;
    private static int[] cols;

    public static void main(String[] args) throws IOException {
        setup();

        for (int col: cols) {
            explode(col);
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void explode(int col) {
        int row = findRow(col);

        if (row == NONE) return;

        int val = matrix[row][col];
        
        for (int[] d: dlist) {
            int di = row, dj = col;
            for (int i = 0; i < val; i ++) {
                if (di < 0 || di >= n || dj < 0 || dj >= n) break;
                matrix[di][dj] = 0;
                di += d[0];
                dj += d[1];
            }
        }

        for (int j = 0; j < n; j ++) {
            int[] temp = new int[n];
            int idx = n - 1;
            for (int i = n - 1; i >= 0; i --) {
                if (matrix[i][j] == 0) continue;
                temp[idx--] = matrix[i][j];
                matrix[i][j] = 0;
            }

            for (int i = n - 1; i > idx; i --) {
                matrix[i][j] = temp[i];
            }
        }
    }

    private static int findRow(int col) {
        for (int i = 0; i < n; i ++) {
            if (matrix[i][col] != 0)
                return i;
        }
        return NONE;
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][n];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cols = new int[m];
        for (int i = 0; i < m; i ++) {
            cols[i] = Integer.parseInt(br.readLine().trim()) - 1;
        }
    }
}