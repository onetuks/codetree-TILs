import java.util.*;
import java.io.*;

public class Main {

    private static final int[][] dlist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int n, m, t;
    private static int[][] matrix;
    private static int[][] currBeads;
    private static int[][] nextBeads;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();

        matrix = new int[n][n]; 
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                matrix[i][j] = sc.nextInt();

        currBeads = new int[n][n];
        for (int i = 0; i < m; i ++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            currBeads[x][y] = 1;
        } 

        for (int i = 0; i < t; i ++) {
            moveBeads();
        }

        int answer = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (currBeads[i][j] != 0) answer++;
            }
        }
        System.out.println(answer);
    }

    private static void moveBeads() {
        nextBeads = new int[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (currBeads[i][j] == 1) {
                    int ti = i, tj = j; 
                    int maxVal = -1;
                    for (int[] d: dlist) {
                        int di = i + d[0];
                        int dj = j + d[1];
                        if (di < 0 || di >= n || dj < 0 || dj >= n) continue;
                        if (matrix[di][dj] > maxVal) {
                            maxVal = matrix[di][dj];
                            ti = di;
                            tj = dj;
                        }
                    }
                    nextBeads[ti][tj] = 1;
                }
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (currBeads[i][j] == 1 && currBeads[i][j] == nextBeads[i][j]) {
                    currBeads[i][j] = 0;
                    nextBeads[i][j] = 0;
                }
            }
        }
    }
}