import java.util.*;
import java.io.*;

public class Main {

    private static final int[][] dlist = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private static final Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('U', 0);
        put('L', 1);
        put('D', 2);
        put('R', 3);
    }};

    private static int t, n, m;
    private static int[][] matrix;
    private static int[][] direct;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();

        for (int tc = 0; tc < t; tc ++) {
            n = sc.nextInt();
            m = sc.nextInt();

            matrix = new int[n][n];
            direct = new int[n][n];

            for (int i = 0; i < m; i ++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                int d = map.get(sc.next().charAt(0));
                matrix[x][y] = 1;
                direct[x][y] = d;
            }

            for (int i = 0; i <= n * n; i ++) {
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
        int[][] demp = new int[n][n];
        
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] > 0) {
                    int d = direct[i][j];
                    int di = i + dlist[d][0];
                    int dj = j + dlist[d][1];
                    // System.out.printf("1) i:%d j:%d di:%d dj:%d d:%d\n", i, j, di, dj, d);
                    if (di < 0 || di >= n || dj < 0 || dj >= n) {
                        d = d >= 2 ? (d - 2) : (d + 2);
                        di = i;
                        dj = j;
                    }
                    // System.out.printf("2) i:%d j:%d di:%d dj:%d d:%d\n", i, j, di, dj, d);
                    temp[di][dj]++;
                    demp[di][dj] = d;
                }
            }
        }

        // for (int i = 0; i < n; i ++) {
        //     for (int j = 0; j < n; j ++) {
        //         System.out.print(temp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (temp[i][j] == 1) {
                    matrix[i][j] = temp[i][j];
                    direct[i][j] = demp[i][j];
                } else {
                    matrix[i][j] = 0;
                    direct[i][j] = 0;
                }
            }
        }
        
        // for (int i = 0; i < n; i ++) {
        //     for (int j = 0; j < n; j ++) {
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }
}