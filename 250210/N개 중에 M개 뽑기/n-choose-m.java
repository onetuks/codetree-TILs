import java.util.*;
import java.io.*;

public class Main {

    private static int n, m;
    private static int[] cntArr;
    private static Set<String> sets = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        cntArr = new int[n + 1];

        combinations(0);
    }

    private static void print(String flag) {
        for (int i = 1; i <= n; i ++) {
            if (flag.charAt(i) == '1') {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static void combinations(int idx) {
        if (idx == m) {
            String flag = buildFlag();
            if (!sets.contains(flag)) {
                print(flag);
                sets.add(flag);
            }
            return;
        }

        for (int i = 1; i <= n; i ++) {
            if (cntArr[i] > 0) continue;
            cntArr[i]++;
            combinations(idx + 1);
            cntArr[i]--;
        }
    }

    private static String buildFlag() {
        StringBuilder sb = new StringBuilder();
        for (int cnt: cntArr) {
            sb.append(cnt);
        }
        return sb.toString();
    }
}