import java.util.*;
import java.io.*;

public class Main {

    private static int n, m, c;
    private static int[][] matrix;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        matrix = new int[n][n];
        for (int i =0;i < n; i++)
            for (int j =0; j < n; j++)
                matrix[i][j] = sc.nextInt();

        solve();

        System.out.println(answer);
    }

    private static void solve() {
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j <= n - m; j ++) {
                List<Integer> list1 = gather(i, j);
                for (int x = 0; x < n; x ++) {
                    for (int y = 0; y <= n - m; y ++) {
                        if (i == x && ((j <= y && y < j + m) || (y <= j && j < y + m))) continue;
                        List<Integer> list2 = gather(x, y);

                        // debug
                        // if (answer < getScore(list1, list2)) {
                        //     System.out.println(i + " " + j + " " + x + " " + y + ": " + getScore(list1, list2));
                        //     for (int l: list1) System.out.print(l + " " );
                        //     System.out.println();
                        //     for (int l: list2) System.out.print(l + " " );
                        //     System.out.println();
                        // }
                        // debug

                        answer = Math.max(answer, getScore(list1, list2));
                    }
                }
            }
        }
    }

    private static List<Integer> gather(int x, int y) {
        int maxSum = Integer.MIN_VALUE;
        List<Integer> maxList = new ArrayList<>();

        List<Integer> vals = new ArrayList<>();
        for (int i = y; i < y + m; i ++)
            vals.add(matrix[x][i]);

        for (int bitmask = 0; bitmask < (1 << vals.size()); bitmask ++) {
            int sum = 0;
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < vals.size(); i ++) {
                if ((bitmask & (1 << i)) == 0) continue;
                int val = vals.get(i);
                sum += val;
                temp.add(val);
            }

            if (sum <= c && sum > maxSum) {
                maxSum = sum;
                maxList = temp;
            }
        }

        return maxList;
    }

    private static int getScore(List<Integer> list1, List<Integer> list2) {
        int result = 0;
        for (int l: list1) result += l * l;
        for (int l: list2) result += l * l;
        return result;
    }
}