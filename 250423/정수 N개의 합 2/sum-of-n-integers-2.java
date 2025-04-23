import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++) {
            prefixSum[i] = sc.nextInt();
            if (i > 0) {
                prefixSum[i] += prefixSum[i - 1];
            }
        }

        for (int i = 0; i <= n - k; i ++) {
            int sum = prefixSum[i + k - 1];
            if (i > 0) {
                sum -= prefixSum[i - 1];
            }
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}