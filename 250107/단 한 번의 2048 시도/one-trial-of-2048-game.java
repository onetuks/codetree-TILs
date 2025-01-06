import java.util.*;
import java.io.*;

public class Main {

    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        matrix = new int[4][4];

        for (int i = 0; i < 4; i ++) {
            for (int j = 0; j < 4; j ++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        char dir = sc.next().charAt(0);

        if (dir == 'L') left();
        else if (dir == 'R') right();
        else if (dir == 'U') up();
        else down();

        for (int i = 0; i < 4; i ++) {
            for (int j = 0; j < 4; j ++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void left() {
        int[][] temp = new int[4][4];

        for (int i = 0; i < 4; i ++) {
            int idx = 0;
            for (int j = 0; j < 3; j ++) {
                if (matrix[i][j] == matrix[i][j + 1]) {
                    temp[i][idx++] = matrix[i][j] * 2;
                    matrix[i][j + 1] = 0;
                } else {
                    if (matrix[i][j] == 0) continue;
                    temp[i][idx++] = matrix[i][j];
                }
            }
            temp[i][idx] = matrix[i][3];

            matrix[i] = new int[4];
            for (int j = 0; j <= idx; j ++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }

    private static void right() {
        int[][] temp = new int[4][4];

        for (int i = 0; i < 4; i ++) {
            int idx = 3;
            for (int j = 3; j > 0; j --) {
                if (matrix[i][j] == matrix[i][j - 1]) {
                    temp[i][idx--] = matrix[i][j] * 2;
                    matrix[i][j - 1] = 0;
                } else {
                    if (matrix[i][j] == 0) continue;
                    temp[i][idx--] = matrix[i][j];
                }
            }
            temp[i][idx] = matrix[i][0];

            matrix[i] = new int[4];
            for (int j = 3; j >= idx; j --) {
                matrix[i][j] = temp[i][j];
            }
        }
    }

    private static void up() {
        int[][] temp = new int[4][4];

        for (int j = 0; j < 4; j ++) {
            int idx = 0;
            for (int i = 0; i < 3; i ++) {
                if (matrix[i][j] == matrix[i + 1][j]) {
                    temp[idx++][j] = matrix[i][j] * 2;
                    matrix[i + 1][j] = 0;
                } else {
                    if (matrix[i][j] == 0) continue;
                    temp[idx++][j] = matrix[i][j];
                }
            }
            temp[idx][j] = matrix[3][j];

            for (int i = 0; i < 4; i ++) {
                matrix[i][j] = 0;
            }
            for (int i = 0; i <= idx; i ++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }

    private static void down() {
        int[][] temp = new int[4][4];

        for (int j = 0; j < 4; j ++) {
            int idx = 3;
            for (int i = 3; i > 0; i --) {
                if (matrix[i][j] == matrix[i - 1][j]) {
                    temp[idx--][j] = matrix[i][j] * 2;
                    matrix[i - 1][j] = 0;
                } else {
                    if (matrix[i][j] == 0) continue;
                    temp[idx--][j] = matrix[i][j];
                }
            }
            temp[idx][j] = matrix[0][j];

            for (int i = 0; i < 4; i ++) {
                matrix[i][j] = 0;
            }
            for (int i = 3; i >= idx; i --) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
}