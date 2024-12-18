import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br;
    private static StringTokenizer st;

    private static int n, m, q;
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        setup();

        for (int i = 0; i < q; i ++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int d = Objects.equals(st.nextToken(), "L") ? 0 : 1;

            erode(r, d);

            int upperRow = r, lowerRow = r;
            int upperDir = d, lowerDir = d;
            while (upperRow > 0 && isEffectable(upperRow, upperRow - 1)) {
                upperRow --;
                upperDir = (upperDir + 1) % 2;
                erode(upperRow, upperDir);
            }
            while (lowerRow < n - 1 && isEffectable(lowerRow, lowerRow + 1)) {
                lowerRow ++;
                lowerDir = (lowerDir + 1) % 2;
                erode(lowerRow, lowerDir);
            }
        }
        
        print();
    }

    private static boolean isEffectable(int originRow, int targetRow) {
        for (int i = 0; i < m; i ++) {
            if (matrix[originRow][i] == matrix[targetRow][i])
                return true;
        }
        return false;
    }

    private static void erode(int r, int d) {
        if (d == 0) {
            int temp = matrix[r][m-1];
            for (int i = m - 1; i > 0; i --) {
                matrix[r][i] = matrix[r][i - 1];
            }
            matrix[r][0] = temp;
        } else {
            int temp = matrix[r][0];
            for (int i = 0; i < m - 1; i ++) {
                matrix[r][i] = matrix[r][i + 1];
            }
            matrix[r][m - 1] = temp;
        }
    }

    private static void print() {
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void setup() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}