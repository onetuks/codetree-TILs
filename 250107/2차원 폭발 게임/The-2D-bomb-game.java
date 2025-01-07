import java.util.*;
import java.io.*;

public class Main {

    private static int n, m, k;
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        setup();

        for (int i = 0; i < k; i ++) {
            explode();
            rotate();
            drop();
        }
        explode();

        int answer = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] != 0) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static void drop() {
        int[][] temp = new int[n][n];

        for (int j = 0; j < n; j ++) {
            int idx = n - 1;
            for (int i = n - 1; i >= 0; i --) {
                if (matrix[i][j] == 0) continue;
                temp[idx--][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                matrix[i][j] = temp[i][j];
    }

    private static void rotate() {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                temp[i][j] = matrix[n - j - 1][i];

        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                matrix[i][j] = temp[i][j];
    }

    private static void explode() {
        for (int j = 0; j < n; j ++) {
            while (explosible(j)) {
                List<Integer> bombs = new ArrayList<>();
                int cnt = 0, val = 0;
                for (int i = 0; i < n; i ++) {
                    if (matrix[i][j] == 0) continue;
                    if (matrix[i][j] == val) {
                        cnt++;
                        continue;
                    }

                    if (cnt < m) {
                        for (int l = 0; l < cnt; l ++) {
                            bombs.add(val);
                        }
                    }

                    cnt = 1;
                    val = matrix[i][j];
                }

                if (cnt < m) {
                    for (int l = 0; l < cnt; l ++) {
                        bombs.add(val);
                    }
                }

                int idx = n - 1;
                for (int l = bombs.size() - 1; l >= 0; l --) {
                    matrix[idx--][j] = bombs.get(l);
                }
                for (int l = idx; l >= 0; l --) {
                    matrix[l][j] = 0;
                }
            }
        }
    }

    private static boolean explosible(int col) {
        int cnt = 0, val = 0;
        for (int i = 0; i < n; i ++) {
            if (matrix[i][col] == 0) continue;
            if (matrix[i][col] == val) {
                cnt++;
                continue;
            }

            if (cnt >= m) return true;
            cnt = 1;
            val = matrix[i][col];
        }
        
        if (cnt >= m) return true;
        return false;
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        matrix = new int[n][n];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}