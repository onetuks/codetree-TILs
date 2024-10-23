import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static int n;

    public static void main(String[] args) {
        n = sc.nextInt();

        int ans = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i ++) {
            int price = sc.nextInt();
            ans = Math.max(ans, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }

        System.out.println(ans);
    }
}