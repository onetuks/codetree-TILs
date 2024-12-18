import java.util.*;
import java.io.*;

public class Main {

    private static final int[][] dlist = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static BufferedReader br;
    private static StringTokenizer st;

    private static int n, m, q;
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        setup();

        for (int i = 0; i < q; i ++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;

            rotate(r1, c1, r2, c2);
            matrix = regulate(r1, c1, r2, c2);
        }

        print();
    }

    private static int[][] regulate(int r1, int c1, int r2, int c2) {
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (i >= r1 && i <= r2 && j >= c1 && j <= c2) {
                    result[i][j] = getAvg(i, j);
                } else {
                    result[i][j] = matrix[i][j];
                }
            }
        }
        return result;
    }

    private static int getAvg(int r, int c) {
        int sum = matrix[r][c];
        int cnt = 1;
        for (int[] d: dlist) {
            int di = r + d[0], dj = c + d[1];
            if (di < 0 || di >= n || dj < 0 || dj >= m) continue;
            cnt ++;
            sum += matrix[di][dj];
        }
        return sum / cnt;
    }

    private static void rotate(int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c2];
        for (int i = c2; i > c1; i --)
            matrix[r1][i] = matrix[r1][i - 1];
        for (int i = r1; i < r2; i ++)
            matrix[i][c1] = matrix[i + 1][c1];
        for (int i = c1; i < c2; i ++)
            matrix[r2][i] = matrix[r2][i + 1];
        for (int i = r2; i > r1; i --)
            matrix[i][c2] = matrix[i - 1][c2];
        matrix[r1 + 1][c2] = temp;
    }

    private static void print() {
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void setup() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}