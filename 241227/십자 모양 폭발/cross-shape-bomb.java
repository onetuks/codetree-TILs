import java.util.*;
import java.io.*;

public class Main {

    private static int[][] dlist = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static int n;
    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(sc.next());

        matrix = new int[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                matrix[i][j] = Integer.parseInt(sc.next());
            }
        }

        int r = Integer.parseInt(sc.next()) - 1;
        int c = Integer.parseInt(sc.next()) - 1;

        activateBomb(r, c);

        printAnswer();
    }

    private static void activateBomb(int r, int c) {
        explosion(r, c);
        fallDown();
    }

    private static void explosion(int r, int c) {
        int value = matrix[r][c] - 1;

        matrix[r][c] = 0;
        for (int[] d: dlist) {
            int di = r, dj = c;
            for (int i = 0; i < value; i ++) {
                di += d[0];
                dj += d[1];
                if (di < 0 || di >= n || dj < 0 || dj >= n) break;
                matrix[di][dj] = 0;
            }
        }
    }

    private static void fallDown() {
        for (int j = 0; j < n; j ++) {
            int[] temp = new int[n];
            int p1 = 0;
            for (int i = n - 1; i >= 0; i --) {
                if (matrix[i][j] != 0)
                    temp[p1++] = matrix[i][j];
            }

            int p2 = 0;
            for (int i = n - 1; i >= 0; i --) {
                if (p2 <= p1)
                    matrix[i][j] = temp[p2++];
                else
                    matrix[i][j] = 0;
            }
        }
    }

    private static void printAnswer() {
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}