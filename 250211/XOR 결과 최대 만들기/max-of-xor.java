import java.util.*;
import java.io.*;

public class Main {

    private static int n, m;
    private static int[] numbers;

    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        numbers = new int[n];
        for (int i = 0; i < n; i ++) 
            numbers[i] = sc.nextInt();

        choose(0, 0, 0);

        System.out.println(answer);
    }

    private static void choose(int idx, int cnt, int val) {
        if (cnt == m || idx == n) {
            if (cnt == m)
                answer = Math.max(answer, val);
            return;
        }

        choose(idx + 1, cnt + 1, val ^ numbers[idx]);
        choose(idx + 1, cnt, val);
    }
}