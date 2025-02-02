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
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j ++)
                matrix[i][j] = sc.nextInt();

        gatherThings();

        System.out.println(answer);
    }

    private static void gatherThings() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - m; j ++) {
                List<Integer> list1 = gatherThingsUnderC(i, j);
                for (int k = 0; k < n; k ++) {
                    for (int l = 0; l <= n - m; l ++) {
                        if (i == k && ((j <= l && l <= j + m) || (l <= j && j <= l + m))) continue;
                        List<Integer> list2 = gatherThingsUnderC(k, l);
                        
                        // debug
                        // if (answer < getScore(list1, list2)) {
                        //     System.out.println(i + " " + j + " " + k + " " + l + " : " + getScore(list1, list2));
                        //     list1.stream().forEach(System.out::println);
                        //     list2.stream().forEach(System.out::println);
                        // }
                        // debug

                        answer = Math.max(answer, getScore(list1, list2));
                    }
                }
            }
        }
    }

    private static int getScore(List<Integer> list1, List<Integer> list2) {
        int result = 0;
        for (int l: list1) result += l * l;
        for (int l: list2) result += l * l;
        return result;
    }

    private static List<Integer> gatherThingsUnderC(int x, int y) {
        int maxSum = 0;
        List<Integer> maxList = new ArrayList<>();

        List<Integer> vals = new ArrayList<>();
        for (int i = y; i < y + m; i ++)
            vals.add(matrix[x][i]);
        
        for (int i = 0; i < (1 << vals.size()); i ++ ){
            int sum = 0;
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < vals.size(); j ++) {
                if ((i & (1 << j)) != 0) {
                    sum += vals.get(j);
                    temp.add(vals.get(j));
                }
            }

            if (sum <= c && sum > maxSum) {
                maxSum = sum;
                maxList = temp;
            }
        }

        return maxList;
    }
}