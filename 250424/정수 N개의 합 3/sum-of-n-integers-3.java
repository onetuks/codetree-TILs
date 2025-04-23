import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= n; j ++) {
                arr[i][j] += arr[i - 1][j];
            }
        }
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= n; j ++) {
                arr[i][j] += arr[i][j - 1];
            }
        }

        for (int i = 1; i <= n - k + 1; i ++) {
            for (int j = 1; j <= n - k + 1; j++) {
                int sum = arr[i + k - 1][j + k - 1]
                    - arr[i + k - 1][j - 1]
                    - arr[i - 1][j + k - 1]
                    + arr[i - 1][j - 1];
                answer = Math.max(answer, sum);
            }
        }

        System.out.println(answer);
    }
}