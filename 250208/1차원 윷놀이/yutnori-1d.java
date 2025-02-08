import java.util.*;
import java.io.*;

public class Main {

    private static final int INIT = -1;

    private static int n, m, k;
    private static int[] dists;
    private static int[] turns;

    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        dists = new int[n];
        turns = new int[n];
        for (int i = 0; i < n; i++) {
            dists[i] = sc.nextInt();
            turns[i] = INIT;
        }

        simulation(0);

        System.out.println(answer);
    }

    private static void simulation(int idx) {
        if (idx == n) {
            calculate();
            return;
        }

        for (int i = 0; i < k; i ++) {
            turns[idx] = i;
            simulation(idx + 1);
            turns[idx] = INIT;
        }
    }

    private static void calculate() {
        int[] objects = new int[k];

        for (int i = 0; i < n; i ++) {
            int objectNum = turns[i];
            int objectDist = dists[i];
            objects[objectNum] += objectDist;
        }

        int count = 0;
        for (int i = 0; i < k; i ++) {
            if (objects[i] >= m - 1)
                count++;
        }

        answer = Math.max(answer, count);
    }
}