import java.util.*;
import java.io.*;

public class Main {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 4;

    private static int n;
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        solve(new ArrayList<>());

        System.out.println(answer);
    }

    private static void solve(List<Integer> number) {
        if (number.size() == n) {
            if (isBeautiful(number)) answer++;
            return;
        }

        for (int i = LOWER_BOUND; i <= UPPER_BOUND; i ++) {
            number.add(i);
            solve(number);
            number.remove(number.size() - 1);
        }
    }

    private static boolean isBeautiful(List<Integer> number) {
        int num = -1;
        int cnt = 0;

        for (int numb: number) {
            if (num != numb) {
                if (cnt % num != 0) 
                    return false;
                num = numb;
                cnt = 1;
                continue;
            }
            cnt++;
        }

        if (cnt % num != 0)
            return false;
        return true;
    }
}