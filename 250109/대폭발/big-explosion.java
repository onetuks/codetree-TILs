import java.util.*;
import java.io.*;

public class Main {
    private static final int[][] dlist = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int n, m, r, c;
    private static int[][] matrix;
    private static int[][] temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;

        matrix = new int[n][n];
        matrix[r][c] = 1;

        for (int k = 0; k < m; k ++) {
            temp = new int[n][n];

            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < n; j ++) {
                    if (matrix[i][j] != 0) {
                        generateBomb(i, j, k);
                    }
                }
            }
            
            matrix = temp;
        }

        int answer = Arrays.stream(matrix).flatMapToInt(Arrays::stream).sum();
        System.out.println(answer);
    }

    private static void generateBomb(int i, int j, int k) {
        temp[i][j] = 1;
        for (int[] d: dlist) {
            int di = i + d[0] * (int) Math.pow(2, k);
            int dj = j + d[1] * (int) Math.pow(2, k);
            if (di < 0 || di >= n || dj < 0 || dj >= n) continue;
            temp[di][dj] = 1;
        }
    }
}