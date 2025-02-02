import java.util.*;
import java.io.*;

public class Main {

    private static final int INIT = -1;

    private static int n, m, c;
    private static int[][] matrix;
    private static int[][] bestVal;

    private static int maxVal;

    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        matrix = new int[n][n];
        bestVal= new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
                bestVal[i][j] = INIT;
            }
        }

        solve();

        System.out.println(answer);
    }

    private static int findMaxVal(int x, int y) {
        if (bestVal[x][y] != INIT) {
            return bestVal[x][y];
        }

        maxVal = 0;
        findMaxSum(x, y, 0, 0, 0);
        bestVal[x][y] = maxVal;
        return bestVal[x][y];
    }

    private static void findMaxSum(int x, int y, int idx, int weight, int val) {
        if (idx == m) {
            if (weight <= c)
                maxVal = Math.max(maxVal, val);
            return;
        }

        findMaxSum(x, y, idx + 1, weight, val);
        findMaxSum(x, y, idx + 1, weight + matrix[x][y + idx], val + matrix[x][y + idx] * matrix[x][y + idx]);
    }

    private static void solve() {
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j <= n - m; j ++) {
                for (int x = 0; x < n; x ++) {
                    for (int y = 0; y <= n - m; y ++) {
                        if (i == x && ((j <= y && y < j + m) || (y <= j && j < y + m))) continue;
                        answer = Math.max(answer, findMaxVal(i, j) + findMaxVal(x, y));
                    }
                }
            }
        }
    }
}