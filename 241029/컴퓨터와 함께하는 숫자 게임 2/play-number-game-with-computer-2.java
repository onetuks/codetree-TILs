import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    private static long m;
    private static long a;
    private static long b;

    public static void main(String[] args) {
        long minCount = Long.MAX_VALUE;
        long maxCount = Long.MIN_VALUE;

        m = sc.nextLong();
        a = sc.nextLong();
        b = sc.nextLong();

        for (int target = a; target <= b; target ++) {
            long count = bisearch(target);
            if (count < minCount) {
                minCount = count;
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }

        System.out.printf("%d %d", minCount, maxCount);
    }

    private static long bisearch(long target) {
        long l = 1, r = m;
        long count = 1;
        while (l <= r) {
            long mid = (l + r) / 2;
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