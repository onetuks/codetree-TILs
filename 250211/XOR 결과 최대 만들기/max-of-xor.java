import java.util.*;
import java.io.*;

public class Main {

    private static int n, m;
    private static int[] numbers;
    private static List<Integer> chosen = new ArrayList<>();
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        numbers = new int[n];
        for (int i = 0; i < n; i ++) 
            numbers[i] = sc.nextInt();

        choose(0);

        System.out.println(answer);
    }

    private static void choose(int idx) {
        if (chosen.size() == m) {
            answer = Math.max(answer, getXorResult());
            return;
        }

        for (int i = idx; i < n; i ++) {
            chosen.add(i);
            choose(i + 1);
            chosen.remove(chosen.size() - 1);
        }
    }

    private static int getXorResult() {
        int result = 0;
        for (int c: chosen) {
            result ^= c;
        }
        return result;
    }
}