import java.util.*;
import java.io.*;

public class Main {

    private static final int m = 4;
    private static final int[][] COUNTER_CLOCKWISE_DLIST = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    private static final int[][] CLOCKWISE_DLIST = {{-1, 1}, {-1, -1}, {1, -1}, {1, 1}};

    private static BufferedReader br;
    private static StringTokenizer st;

    private static int n;
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        setup();

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;

        int[] mlist = new int[m];
        for (int i = 0; i < m; i ++) {
            mlist[i] = Integer.parseInt(st.nextToken());
        }

        int dir = Integer.parseInt(st.nextToken());

        rotate(r, c, mlist, dir);

        print();
    }

    private static void rotate(int r, int c, int[] mlist, int dir) {
        int temp = matrix[r][c];
        int x = r, y = c;

        for (int i = 0; i < m; i ++) {
            int dist = dir == 0 ? mlist[m - 1 - i] : mlist[i];
            while (dist-- > 0) {
                int dx = x + (dir == 0 ? COUNTER_CLOCKWISE_DLIST[i][0] : CLOCKWISE_DLIST[i][0]);
                int dy = y + (dir == 0 ? COUNTER_CLOCKWISE_DLIST[i][1] : CLOCKWISE_DLIST[i][1]);
                matrix[x][y] = matrix[dx][dy];
                x = dx;
                y = dy;
            }
        }
        
        if (dir == 0) {
            matrix[r - 1][c + 1] = temp;
        } else {
            matrix[r - 1][c - 1] = temp;
        }
    }

    private static void print() {
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void setup() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        matrix = new int[n][n];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}