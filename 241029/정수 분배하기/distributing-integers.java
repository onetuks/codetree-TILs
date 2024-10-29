import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    private static int n;
    private static int m;

    private static int[] nums;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();

        int maxNum = Integer.MIN_VALUE;
        nums = new int[n];
        for (int i = 0; i < n; i ++) {
            nums[i] = sc.nextInt();
            maxNum = Math.max(maxNum, nums[i]);
        }

        int l = 1, r = maxNum;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (isPossible(mid)) {
                ans = Math.max(ans, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean isPossible(int k) {
        int count = 0;
        for (int num: nums) {
            count += num / k;
        }
        return count >= m;
    }
}