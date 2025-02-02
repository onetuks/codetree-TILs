import java.util.*;
import java.io.*;

public class Main {

    private static int k, n;
    private static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();

        permutations();
    }

    private static void permutations() {
        if (numbers.size() == n) {
            print();
            return;
        }

        for (int i = 1; i <= k; i ++) {
            if (impossible(i)) continue;
            numbers.add(i);
            permutations();
            numbers.remove(numbers.size() - 1);
        }
    }

    private static boolean impossible(int num) {
        int cnt = 1;
        for (int i = numbers.size() - 1; i >= 0; i --) {
            if (num != numbers.get(i)) break;
            cnt++;
        }
        return cnt >= 3;
    }

    private static void print() {
        for (int number: numbers)
            System.out.print(number + " ");
        System.out.println();
    }
}