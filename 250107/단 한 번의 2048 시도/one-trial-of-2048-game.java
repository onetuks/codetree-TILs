import java.util.*;
import java.io.*;

public class Main {

    private static final int NONE = -1;
    private static int n = 4;
    private static int[][] matrix = new int[n][n];
    private static int[][] temp = new int[n][n];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                matrix[i][j] = sc.nextInt();

        char dir = sc.next().charAt(0);
        int cnt = 0;
        
        if (dir == 'R') cnt = 2;
        else if (dir == 'U') cnt = 3;
        else if (dir == 'D') cnt = 1;

        solve(cnt);

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    private static void solve(int cnt) {
        for (int i = 0; i < cnt; i ++) rotate();
        pullLeft();
        for (int i = 0; i < n - cnt; i ++) rotate();
    }

    private static void rotate() {
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                temp[i][j] = 0;

        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                temp[i][j] = matrix[n - j - 1][i];

        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                matrix[i][j] = temp[i][j];
    }

    private static void pullLeft() {
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                temp[i][j] = 0;

        for (int i = 0; i < n; i ++) {
            int idx = 0, val = NONE;
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == 0) continue;
                if (val == NONE) {
                    val = matrix[i][j];
                } else if (matrix[i][j] == val) {
                    temp[i][idx++] = val * 2;
                    val = NONE;
                } else {
                    temp[i][idx++] = val;
                    val = matrix[i][j];
                }
            }

            if (val != NONE)
                temp[i][idx++] = val;
        }

        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++) 
                matrix[i][j] = temp[i][j];
    }
}