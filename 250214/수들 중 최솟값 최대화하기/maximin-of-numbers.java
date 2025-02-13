import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[][] matrix;
    private static boolean[] visited;

    private static int answer = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        matrix = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                matrix[i][j] = sc.nextInt();

        findMaximumMinValue(0, 0, Integer.MAX_VALUE);

        System.out.println(answer);
    }

    private static void findMaximumMinValue(int row, int cnt, int minVal) {
        if (cnt == n) {
            answer = Math.max(answer, minVal);
            return;
        }

        for (int col = 0; col < n; col ++) {
            if (visited[col]) continue;

            visited[col] = true;
            findMaximumMinValue(row + 1, cnt + 1, Math.min(minVal, matrix[row][col]));
            visited[col] = false;
        }
    }
}