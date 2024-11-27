import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int m;
    private static int[][] matrix;

    private static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                matrix[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j++) {
                for (int k = i; k < n; k ++) {
                    for (int l = j; l < m; l ++) {
                        if (hasAllPositive(i, j, k, l)) {
                            answer = Math.max(answer, (k - i + 1) * (l - j + 1));
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean hasAllPositive(int i, int j, int k, int l) {
        for (int u = i; u <= k; u ++) {
            for (int v = j; v <= l; v ++) {
                if (matrix[u][v] <= 0) {
                    return false;
                }
            }
        }
        return true;
    }
}