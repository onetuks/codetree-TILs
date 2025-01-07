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

        solve(dir);

        for (int i = 0; i < 4; i ++) {
            for (int j = 0; j < 4; j ++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void solve(char dir) {
        pull(dir);
        merge(dir);
        pull(dir);
    }

    private static void merge(char dir) {
        int[][] temp = new int[4][4];

        if (dir == 'L') {
            for (int i = 0; i < 4; i ++) {
                for (int j = 0; j < 3; j ++) {
                    if (matrix[i][j] == matrix[i][j + 1]) {
                        matrix[i][j] *= 2;
                        matrix[i][j + 1] = 0;
                    }
                }
            }
        } else if (dir == 'R') {
            for (int i = 0; i < 4; i ++) {
                for (int j = 3; j > 0; j --) {
                    if (matrix[i][j] == matrix[i][j - 1]) {
                        matrix[i][j] *= 2;
                        matrix[i][j - 1] = 0;
                    }
                }
            }
        } else if (dir == 'U') {
            for (int j = 0; j < 4; j ++) {
                for (int i = 0; i < 3; i ++) {
                    if (matrix[i][j] == matrix[i + 1][j]) {
                        matrix[i][j] *= 2;
                        matrix[i + 1][j] = 0;
                    }
                }
            }
        } else {
            for (int j = 0; j < 4; j ++) {
                for (int i = 3; i > 0; i --) {
                    if (matrix[i][j] == matrix[i - 1][j]) {
                        matrix[i][j] *= 2;
                        matrix[i - 1][j] = 0;
                    }
                }
            }
        }
    }

    private static void pull(char dir) {
        int[][] temp = new int[4][4];

        if (dir == 'L') {
            for (int i = 0; i < 4; i ++) {
                int idx = 0;
                for (int j = 0; j < 4; j ++) {
                    if (matrix[i][j] == 0) continue;
                    temp[i][idx++] = matrix[i][j];
                }
            }
        } else if (dir == 'R') {
            for (int i = 0; i < 4; i ++) {
                int idx = 3;
                for (int j = 3; j >= 0; j --) {
                    if (matrix[i][j] == 0) continue;
                    temp[i][idx--] = matrix[i][j];
                }
            }
        } else if (dir == 'U') {
            for (int j = 0; j < 4; j ++) {
                int idx = 0;
                for (int i = 0; i < 4; i ++) {
                    if (matrix[i][j] == 0) continue;
                    temp[idx++][j] = matrix[i][j];
                }
            }
        } else {
            for (int j = 0; j < 4; j ++) {
                int idx = 3;
                for (int i = 3; i >= 0; i --) {
                    if (matrix[i][j] == 0) continue;
                    temp[idx--][j] = matrix[i][j];
                }
            }
        }

        for (int i = 0; i < 4; i ++) {
            for (int j = 0; j < 4; j ++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
}