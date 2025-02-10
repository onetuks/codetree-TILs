import java.util.*;
import java.io.*;

public class Main {

    private static int n, m;
    private static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        numbers = new int[m];

        combinations(1, 0);
    }

    private static void combinations(int num, int cnt) {
        if (num == n + 1 || cnt == m) {
            if (cnt == m)
                printNumbers();
            return;
        }

        numbers[cnt] = num;
        combinations(num + 1, cnt + 1);
        numbers[cnt] = 0;

        combinations(num + 1, cnt);
    }

    private static void printNumbers() {
        for (int num: numbers)
            System.out.print(num + " ");
        System.out.println();
    }
}