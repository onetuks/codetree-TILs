import java.util.*;
import java.io.*;

public class Main {
    
    private static int n;
    private static List<Integer> numbers = new ArrayList<>();
    private static int totalSum = 0;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < 2 * n; i++) {
            int num = sc.nextInt();
            numbers.add(num);
            totalSum += num;
        }

        makeGroup(0, 0, 0);

        System.out.print(answer);
    }

    private static void makeGroup(int idx, int cnt, int val) {
        if (cnt == n || idx == 2 * n) {
            if (cnt == n)
                answer = Math.min(answer, Math.abs(val - (totalSum - val)));
            return;
        }

        makeGroup(idx + 1, cnt + 1, val + numbers.get(idx));
        makeGroup(idx + 1, cnt, val);
    }
}