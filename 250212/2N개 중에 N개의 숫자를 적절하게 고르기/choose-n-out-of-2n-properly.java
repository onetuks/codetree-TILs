import java.util.*;
import java.io.*;

public class Main {
    
    private static int n;
    private static List<Integer> numbers = new ArrayList<>();
    private static Set<Integer> group = new HashSet<>();
    private static int totalSum = 0;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < 2 * n; i++) {
            int num = sc.nextInt();
            numbers.add(num);
            totalSum += num;
        }

        makeGroup(0);

        System.out.print(answer);
    }

    private static void makeGroup(int idx) {
        if (group.size() == n) {
            answer = Math.min(answer, getDiff());
            return;
        }

        for (int i = idx; i < 2 * n; i++) {
            group.add(numbers.get(i));
            makeGroup(i + 1);
            group.remove(numbers.get(i));
        }
    }

    private static int getDiff() {
        int sumOfGroup = 0;
        for (int g: group) sumOfGroup += g;
        return Math.abs(sumOfGroup - (totalSum - sumOfGroup));
    }
}