import java.util.*;
import java.io.*;

public class Main {

    private static int n, m, k;
    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt() - 1;

        matrix = new int[n][n];
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                matrix[i][j] = sc.nextInt();

        int row = getMaxRow(k, k + m);

        for (int i = 0; i < m; i++) {
            matrix[row][k + i] = 1;
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                System.out.print(matrix[i][j] + " " );
            }
            System.out.println();
        }
    }

    private static int getMaxRow(int sc, int ec) {
        for (int i = 0; i < n; i ++) {
            for (int j = sc; j < ec; j ++) {
                if (matrix[i][j] != 0) return i - 1;
            }
        }
        return n - 1;
    }
}