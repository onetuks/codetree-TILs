import java.util.*;
import java.io.*;

public class Main {

    private static int n, m, c;
    private static int[][] matrix;
    private static int[][] bestVal;

    private static int maxVal;
    private static int[] temp;

    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        matrix = new int[n][n];
        for (int i =0;i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();

        preprocessing();

        // // debug
        // for (int i = 0; i < n; i ++)
        //     System.out.println(Arrays.toString(bestVal[i]));
        // // debug

        solve();

        System.out.println(answer);
    }

    private static void preprocessing() {
        bestVal = new int[n][n];

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j <= n - m; j ++) {
                bestVal[i][j] = findMaxVal(i, j);
            }
        }
    }

    private static int findMaxVal(int x, int y) {
        temp = new int[m];
        for (int i = y; i < y + m; i ++)
            temp[i - y] = matrix[x][i];

        maxVal = 0;
        findMaxSum(0, 0, 0);
        return maxVal;
    }

    private static void findMaxSum(int idx, int weight, int val) {
        if (idx == m) {
            if (weight <= c)
                maxVal = Math.max(maxVal, val);
            return;
        }

        findMaxSum(idx + 1, weight, val);
        findMaxSum(idx + 1, weight + temp[idx], val + temp[idx] * temp[idx]);
    }

    private static void solve() {
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j <= n - m; j ++) {
                for (int x = 0; x < n; x ++) {
                    for (int y = 0; y <= n - m; y ++) {
                        if (i == x && ((j <= y && y < j + m) || (y <= j && j < y + m))) continue;
                        answer = Math.max(answer, bestVal[i][j] + bestVal[x][y]);
                    }
                }
            }
        }
    }
}