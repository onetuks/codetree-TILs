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

        visited = new boolean[n];
        matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j ++)
                matrix[i][j] = sc.nextInt();

        findMaxSum(0, 0);

        System.out.println(answer);
    }

    private static void findMaxSum(int row, int sum) {
        if (row == n) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < n; i ++) {
            if (visited[i]) continue;

            visited[i] = true;
            findMaxSum(row + 1, sum + matrix[row][i]);
            visited[i] = false;
        }
    }
}