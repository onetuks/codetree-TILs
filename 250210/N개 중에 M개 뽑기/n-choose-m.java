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

    private static void combinations(int num, int idx) {
        if (num == n + 1 || idx == m) {
            if (idx == m) 
                printNumbers();
            return;
        }

        for (int i = num; i <= n; i ++) {
            numbers[idx] = i;
            combinations(i + 1, idx + 1);
            numbers[idx] = 0;
        }
    }

    private static void printNumbers() {
        for (int num: numbers)
            System.out.print(num + " ");
        System.out.println();
    }
}