import java.util.*;
import java.io.*;

public class Main {

    private static final int[][] dlist = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static int n, x, y;
    private static char[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        x = sc.nextInt() - 1;
        y = sc.nextInt() - 1;

        matrix = new char[n][n];
        sc.nextLine();
        for (int i = 0; i < n; i ++) {
            matrix[i] = sc.nextLine().toCharArray();
        }

        int answer = -1;
        int dir = 0;

        while (true) {
            answer++;
            if (answer > n * n) break;

            int rightDir = (dir + 1) % dlist.length;
            int di = x + dlist[rightDir][0];
            int dj = y + dlist[rightDir][1];
            if (di < 0 || di >= n || dj < 0 || dj >= n) continue;
            if (matrix[di][dj] == '.') dir = rightDir;

            di = x + dlist[dir][0];
            dj = y + dlist[dir][1];
            if (di < 0 || di >= n || dj < 0 || dj >= n) { 
                answer++; 
                break;
            }
            if (matrix[di][dj] == '#') {
                dir = (dir - 1 < 0) ? 3 : dir - 1;
            }

            x += dlist[dir][0];
            y += dlist[dir][1];
            if (x < 0 || x >= n || y < 0 || y >= n) { 
                answer++; 
                break;
            }
        }

        if (answer > n * n) answer = -1;
        System.out.println(answer);
    }
}