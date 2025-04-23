import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] matrix = new int[n + 1][n + 1];
        int[][] prefixSum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // make prefixSum: S(i,j) = M(i,j) + S(i-1,j) + S(i,j-1) - S(i-1,j-1)
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= n; j ++) {
                prefixSum[i][j] = matrix[i][j] + prefixSum[i - 1][j]
                    + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        // calculate k * k range sum
        for (int i = 1; i <= n - k + 1; i ++) {
            for (int j = 1; j <= n - k + 1; j ++) {
                int sum = prefixSum[i + k - 1][j + k - 1] 
                    - prefixSum[i + k - 1][j - 1]
                    - prefixSum[i - 1][j + k - 1]
                    + prefixSum[i - 1][j - 1];
                answer = Math.max(answer, sum);
            }
        }

        System.out.println(answer);
    }
}