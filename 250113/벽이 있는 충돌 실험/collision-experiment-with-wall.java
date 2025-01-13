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
    private static int[][] currGrid;
    private static int[][] nextGrid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();

        for (int tc = 0; tc < t; tc ++) {
            n = sc.nextInt();
            m = sc.nextInt();

            currGrid = new int[n][n];
            for (int i = 0; i < m; i ++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                int d = map.get(sc.next().charAt(0));
                currGrid[x][y] = d;
            }

            for (int i = 0; i <= n * n; i ++) {
                moveAll();
            }

            int answer = 0;
            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < n; j ++) {
                    if (currGrid[i][j] > 0) answer++;
                }
            }
            System.out.println(answer);
        }
    }

    private static void moveAll() {
        nextGrid = new int[n][n];

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (currGrid[i][j] > 0) {
                    int d = currGrid[i][j];
                    int di = i + dlist[d][0];
                    int dj = j + dlist[d][1];
                    if (di < 0 || di >= n || dj < 0 || dj >= n) {
                        d = d > 2 ? (d - 2) : (d + 2);
                        if (nextGrid[i][j] > 0) {
                            nextGrid[i][j] = 0;
                            continue;
                        }
                        nextGrid[i][j] = d;
                        continue;
                    }
                    if (nextGrid[di][dj] > 0) {
                        nextGrid[di][dj] = 0;
                        continue;
                    }
                    nextGrid[di][dj] = d;
                }
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                currGrid[i][j] = nextGrid[i][j];
                // System.out.printf("%d ", nextGrid[i][j]);
            }
            // System.out.println();
        }
    }
}