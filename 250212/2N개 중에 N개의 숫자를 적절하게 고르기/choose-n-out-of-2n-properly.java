import java.util.*;
import java.io.*;

public class Main {
    
    private static int n;
    private static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        numbers = new int[n * 2];
        for (int i = 0; i < 2 * n; i ++)
            numbers[i] = sc.nextInt();

        Arrays.sort(numbers);

        int sum1 = 0, sum2 = 0;

        for (int i = 2 * n - 1; i >= 0; i --) {
            if (sum1 < sum2)
                sum1 += numbers[i];
            else
                sum2 += numbers[i];
        }

        System.out.println(Math.abs(sum1 - sum2));
    }
}