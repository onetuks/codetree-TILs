import java.util.*;
import java.io.*;

public class Main {

    private static int n, m;
    private static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        combinations(0, 0);
    }

    private static void combinations(int num, int cnt) {
        if (cnt == m) {
            printNumbers();
            return;
        }

        for (int i = num + 1; i <= n; i ++) {
            numbers.add(i);
            combinations(i, cnt + 1);
            numbers.remove(numbers.size() - 1);
        }
    }

    private static void printNumbers() {
        for (int num: numbers)
            System.out.print(num + " ");
        System.out.println();
    }
}