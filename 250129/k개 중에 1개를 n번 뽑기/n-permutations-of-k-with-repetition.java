import java.util.*;
import java.io.*;

public class Main {

    private static int k, n;
    private static List<Integer> num = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();

        permutations();
    }

    private static void permutations() {
        if (num.size() == n) {
            print();
            return; 
        }

        for (int i = 1; i <= k; i ++) {
            num.add(i);
            permutations();
            num.remove(num.size() - 1);
        }
    }

    private static void print() {
        for (int i: num) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}