import java.util.*;

public class Main {

    private static long answer = 0;

    private static int n;
    private static long[] arr;
    private static long[] left;
    private static long[] right;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new long[n + 2];
        for (int i = 1; i <= n; i ++) {
            arr[i] = sc.nextLong();
        }

        left = new long[n + 2];
        right = new long[n + 2];

        for (int i = 1; i <= n; i ++) {
            left[i] = left[i-1] + arr[i];
        }
        for (int i = n; i >= 1; i --) {
            right[i] = right[i+1] + arr[i];
        }

        // System.out.println(Arrays.toString(arr));

        answer = dfs(1, n, false);

        System.out.println(answer);
    }

    private static long dfs(int s, int e, boolean isLeaf) {
        long count = 0L;
        for (int i = s; i <= e; i ++) {
            if (i == s) continue;
            long leftSum = left[i-1] - left[s-1];
            long rightSum = right[i] - right[e+1];

            // System.out.printf("s:%d~e:%d(i:%d) -> l[i-1]:%d r[i]:%d (cnt:%d)\n", s, e, i, leftSum, rightSum, count);

            if (leftSum == rightSum) {
                if (!isLeaf) {
                    long leftCount = dfs(s, i-1, !isLeaf);
                    long rightCount = dfs(i, e, !isLeaf);
                    count += leftCount * rightCount;
                } else {
                    count += 1;
                }
            }
        }
        return count;
    }
}