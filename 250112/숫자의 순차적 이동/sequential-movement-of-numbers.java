import java.util.*;
import java.io.*;

public class Main {

    private static final int[][] dlist = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    private static int n, m;
    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        matrix = new int[n][n];
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                matrix[i][j] = sc.nextInt();

        for (int l = 0; l < m; l ++) {
            for (int t = 1; t <= n * n; t ++) {
            boolean flag = false;
            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < n; j ++) {
                    if (matrix[i][j] == t) {
                        flag = true;
                        move(i, j);
                        break;
                    }
                }
                if (flag) break; 
            }
        }
        }

        print();
    }

    private static void print() {
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void move(int i, int j) {
        int ti = i, tj = j;
        int maxVal = -1;
        for (int[] d: dlist) {
            int di = i + d[0];
            int dj = j + d[1];
            if (di < 0 || di >= n || dj < 0 || dj >= n) continue;
            if (matrix[di][dj] > maxVal) {
                maxVal = matrix[di][dj];
                ti = di;
                tj = dj;
            }
        }
        int temp = matrix[ti][tj];
        matrix[ti][tj] = matrix[i][j];
        matrix[i][j] = temp;
    }
}