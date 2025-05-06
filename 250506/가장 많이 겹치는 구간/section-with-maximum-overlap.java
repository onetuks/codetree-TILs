import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[200_002];

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            dp[x1] += 1;
            dp[x2 + 1] -= 1;
        }
        
        int answer = 0;
        for (int i = 1; i < 200_002; i++) {
            dp[i] += dp[i-1];
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}