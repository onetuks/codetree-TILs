import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int m;
    private static int[][] matrix;

    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j ++)
                matrix[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int sx1 = 0; sx1 < n; sx1 ++) {
            for (int sy1 = 0; sy1 < m; sy1 ++) {
                for (int ex1 = sx1; ex1 < n; ex1 ++) {
                    for (int ey1 = sy1; ey1 < m; ey1 ++) {
                        for (int sx2 = 0; sx2 < n; sx2 ++) {
                            for (int sy2 = 0; sy2 < m; sy2 ++) {
                                for (int ex2 = sx2; ex2 < n; ex2 ++) {
                                    for (int ey2 = sy2; ey2 < m; ey2 ++) {
                                        if (isOverlap(sx1, sy1, ex1, ey1, sx2, sy2, ex2, ey2))
                                            continue;
                                        int sum = getSum(sx1, sy1, ex1, ey1) + getSum(sx2, sy2, ex2, ey2);
                                        // System.out.printf("sx1:%d, sy1:%d, ex1:%d, ey1:%d, sx2:%d, sy2:%d, ex2:%d, ey2:%d, sum:%d\n", sx1, sy1, ex1, ey1, sx2, sy2, ex2, ey2, sum);
                                        answer = Math.max(answer, sum);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean isOverlap(int sx1, int sy1, int ex1, int ey1, int sx2, int sy2, int ex2, int ey2) {
        int[][] visited = new int[n][m];
        for (int i = sx1; i <= ex1; i ++)
            for (int j = sy1; j <= ey1; j ++)
                visited[i][j] ++;
        for (int i = sx2; i <= ex2; i ++)
            for (int j = sy2; j <= ey2; j ++)
                visited[i][j] ++;

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (visited[i][j] > 1)
                    return true;
            }
        }
        return false;
    }

    private static int getSum(int sx, int sy, int ex, int ey) {
        int sum = 0;
        for (int i = sx; i <= ex; i ++) {
            for (int j = sy; j <= ey; j ++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}