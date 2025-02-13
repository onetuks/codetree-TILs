import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static List<Integer> sequence = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        visited = new boolean[n + 1];

        permutations(0);
    }

    private static void permutations(int cnt) {
        if (cnt == n) {
            print();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            sequence.add(i);
            visited[i] = true;
            permutations(cnt + 1);
            sequence.remove(sequence.size() - 1);
            visited[i] = false;
        }
    }

    private static void print() {
        for (int seq: sequence)
            System.out.print(seq + " ");
        System.out.println();
    }
}