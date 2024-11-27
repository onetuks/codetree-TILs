import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[][] matrix;

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        matrix = new int[n][n];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n; j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 2; i < n; i ++) {
            for (int j = 1; j < n - 1; j ++) {
                int sum = getSum(i, j);
                // System.out.printf("i: %d j: %d sum: %d\n", i, j, sum);
                answer = Math.max(answer, sum);
            }
        }

        System.out.println(answer);
    }

    private static int getSum(int x, int y) {
        int i = x, j = y;
        int sum = 0;
        
        while (i - 1 > 0 && j + 1 < n) {
            i = i - 1;
            j = j + 1;
            sum += matrix[i][j];
        }

        while (i - 1 >= 0 && j - 1 > 0) {
            i = i - 1;
            j = j - 1;
            sum += matrix[i][j];
        }

        while (i + 1 < n - 1 && j - 1 >= 0) {
            i = i + 1;
            j = j - 1;
            sum += matrix[i][j];
        }

        while (i + 1 < n && j + 1 < n) {
            i = i + 1;
            j = j + 1;
            sum += matrix[i][j];
        }

        return sum;
    }
}