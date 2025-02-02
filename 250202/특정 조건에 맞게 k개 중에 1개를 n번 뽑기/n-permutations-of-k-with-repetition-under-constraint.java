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
        int length = numbers.size();
        return length >= 2 && num == numbers.get(length - 1) && num == numbers.get(length - 2);
    }

    private static void print() {
        for (int number: numbers)
            System.out.print(number + " ");
        System.out.println();
    }
}