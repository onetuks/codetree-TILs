import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    private static int m;
    private static int a;
    private static int b;

    public static void main(String[] args) {
        int minCount = Integer.MAX_VALUE;
        int maxCount = Integer.MIN_VALUE;

        m = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();

        for (int target = a; target <= b; target ++) {
            int count = bisearch(target);
            if (count < minCount) {
                minCount = count;
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }

        System.out.printf("%d %d", minCount, maxCount);
    }

    private static int bisearch(int target) {
        int l = 1, r = m;
        int count = 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid == target) {
                return count;
            }
            
            if (mid < target) {
                l = mid + 1;
            } else if (mid > target) {
                r = mid - 1;
            }

            count++;
        }
        return count;
    }
}