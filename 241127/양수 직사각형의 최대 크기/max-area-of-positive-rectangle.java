import java.util.*;
import java.io.*;

public class Main {

    private static int n, m;
    private static int[][] matrix;

    private static int[][] deepMax;
    private static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        preprocessing();

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                int maxHeight = 20;
                for (int l = j; l < m; l ++) {
                    maxHeight = Math.min(maxHeight, deepMax[i][l]);
                    answer = Math.max(answer, maxHeight * (l - j + 1));
                }
            }
        }

        System.out.println(answer);
    }

    // O(n * m)
    private static void preprocessing() {
        deepMax = new int[n][m];
        for (int j = 0; j < m; j ++)
            deepMax[n - 1][j] = matrix[n - 1][j] > 0 ? 1 : 0;

        for (int i = n - 2; i >= 0; i --) {
            for (int j = 0; j < m; j ++) {
                if (matrix[i][j] > 0) {
                    deepMax[i][j] = deepMax[i + 1][j] + 1;
                }
            }
        }
    }
}