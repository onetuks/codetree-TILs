import java.util.*;

public class Main {

    private static int n, q;
    private static int[] arr;
    private static int[] left;
    private static int[] right;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        q = sc.nextInt();

        arr = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        left = new int[n + 2];
        right = new int[n + 2];

        for (int i = 1; i <= n; i ++) {
            left[i] = Math.max(left[i-1], arr[i]);
        }
        for (int i = n; i >= 1; i --) {
            right[i] = Math.max(right[i+1], arr[i]);
        }

        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int ans = Math.max(left[a-1], right[b+1]);
            System.out.println(ans);
        }
    }
}