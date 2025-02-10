import java.util.*;
import java.io.*;

public class Main {
    
    private static int n;
    private static int[] jumps;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        jumps = new int[n];
        for (int i = 0; i < n; i ++)
            jumps[i] = sc.nextInt();

        backtrack(0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void backtrack(int idx, int cnt) {
        if (idx >= n - 1) {
            answer = Math.min(answer, cnt);
            return;
        }

        for (int step = 1; step <= jumps[idx]; step ++)
            backtrack(idx + step, cnt + 1);
    }
}