import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[][] matrix;

    private static int ans = 0;

    public static void main(String[] args) throws IOException {
        setup();

        curved();
        straight();

        System.out.println(ans);
    }

    private static void curved() {
        for (int i = 0; i <= n - 2; i ++) {
            for (int j = 0; j <= n - 2; j ++) {
                List<Integer> nums = new ArrayList<>();
                for (int x = 0; x < 2; x ++) {
                    for (int y = 0; y < 2; y ++) {
                        nums.add(matrix[i + x][j + y]);
                    }
                }
                nums.sort((a, b) -> b - a);
                int sum = 0;
                for (int k = 0; k < 3; k ++)
                    sum += nums.get(k);
                ans = Math.max(ans, sum);
            }
        }
    }

    private static void straight() {
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                int horiz = 0;
                if (j + 2 < n) {
                    for (int k = 0; k < 3; k ++)
                        horiz += matrix[i][j + k];
                }
                
                int verti = 0;
                if (i + 2 < n) {
                    for (int k = 0; k < 3; k ++)
                        verti += matrix[i + k][j];
                }

                ans = Math.max(ans, horiz);
                ans = Math.max(ans, verti);
            }
        }
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][n];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}