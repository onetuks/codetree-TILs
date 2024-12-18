import java.util.*;
import java.io.*;

public class Main {

    private static int n, t;
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        setup();

        for (int i = 0; i < t; i ++) {
            rotate();
        }

        print();
    }

    private static void rotate() {
        int temp = matrix[0][n - 1];
        for (int i = n - 1; i > 0; i --) {
            matrix[0][i] = matrix[0][i - 1];
        }
        matrix[0][0] = matrix[1][0];
        for (int i = 0; i < n - 1; i ++) {
            matrix[1][i] = matrix[1][i + 1];
        }
        matrix[1][n - 1] = temp;
    }

    private static void print() {
        StringJoiner joiner = new StringJoiner(" ");
        for (int num: matrix[0]) {
            joiner.add(String.valueOf(num));
        }
        System.out.println(joiner.toString());

        joiner = new StringJoiner(" ");
        for (int i = n - 1; i >= 0; i --) {
            joiner.add(String.valueOf(matrix[1][i]));
        }
        System.out.println(joiner.toString());
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        matrix = new int[2][n];
        for (int i = 0; i < 2; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j ++) {
                if (i == 0)
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                else
                    matrix[i][n-j-1] = Integer.parseInt(st.nextToken());
            }
        }
    }
}