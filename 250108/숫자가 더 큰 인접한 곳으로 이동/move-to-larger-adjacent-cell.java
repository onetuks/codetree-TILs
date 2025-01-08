import java.util.*;

public class Main {

    private static final int[][] dlist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int n;
    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;

        matrix = new int[n][n];
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                matrix[i][j] = sc.nextInt();

        List<Integer> answer = new ArrayList<>();

        int i = r, j = c;
        while (true) {
            int curr = matrix[i][j];
            answer.add(curr);
            
            boolean existsBiggerValue = false;
            for (int[] d: dlist) {
                int di = i + d[0], dj = j + d[1];
                if (di < 0 || di >= n || dj < 0 || dj >= n) continue;
                if (curr < matrix[di][dj]) {
                    i = di;
                    j = dj;
                    existsBiggerValue = true;
                    break;
                }
            }

            if (!existsBiggerValue) break;
        }

        for (int ans: answer) {
            System.out.print(ans + " ");
        }
    }
}