import java.util.*;
import java.io.*;

public class Main {

    private static final int[][] dlist = {{}, {-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private static final Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('U', 1);
        put('L', 2);
        put('D', 3);
        put('R', 4);
    }};

    private static int t, n, m;
    private static int[][] matrix;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            matrix = new int[n][n];

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken()) - 1;
                int j = Integer.parseInt(st.nextToken()) - 1;
                int d = map.get(st.nextToken().charAt(0));
                matrix[i][j] = d;
            }

            for (int i = 0; i <= n * 2; i ++) {
                moveAll();
            }

            int answer = 0;
            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < n; j ++) {
                    if (matrix[i][j] > 0) answer++;
                }
            }
            System.out.println(answer);
        }
    }

    private static void moveAll() {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] > 0) {
                    int d = matrix[i][j];
                    int di = i + dlist[d][0];
                    int dj = j + dlist[d][1];
                    if (di < 0 || di >= n || dj < 0 || dj >= n) {
                        d = d > 2 ? (d - 2) : (d + 2);
                        di = i;
                        dj = j;
                    }
                    if (temp[di][dj] > 0) {
                        temp[di][dj] = 0;
                    } else {
                        temp[di][dj] = d;
                    }
                }
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (temp[i][j] > 0) {
                    matrix[i][j] = temp[i][j];
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}