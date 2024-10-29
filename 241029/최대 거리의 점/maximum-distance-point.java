import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    private static int n;
    private static int m;

    private static int[] arr;

    public static void main(String[] args) {
        n = sc.nextInt(); 
        m = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int l = 0, r = 1_000_000_000;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (isPossible(mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean isPossible(int dist) {
        int cnt = 1;
        int idx = 0;
        for (int i = 1; i < n; i ++) {
            if (arr[i] - arr[idx] >= dist) {
                cnt ++;
                idx = i;
            }
        }
        return cnt >= m;
    }
}