import java.util.*;
import java.io.*;

public class Main {

    private static final int[][] DLIST = {{}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    private static int n;
    private static int[][] matrix;
    private static int[][] direct;

    private static int answer = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        matrix = new int[n][n];
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                matrix[i][j] = sc.nextInt();
            
        direct = new int[n][n];
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                direct[i][j] = sc.nextInt();

        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;

        backtrack(r, c, 0);

        System.out.println(answer);
    }

    private static void backtrack(int r, int c, int step) {
        answer = Math.max(answer, step);

        List<int[]> nextNodes = getNextNodes(r, c);

        for (int[] nextNode: nextNodes)
            backtrack(nextNode[0], nextNode[1], step + 1);
    }

    private static List<int[]> getNextNodes(int r, int c) {
        List<int[]> nodes = new ArrayList<>();
        int num = matrix[r][c];
        int dir = direct[r][c];
        int di = r + DLIST[dir][0], dj = c + DLIST[dir][1];
        while (inRange(di, dj)) {
            if (matrix[di][dj] > num)
                nodes.add(new int[]{di, dj});
            di += DLIST[dir][0];
            dj += DLIST[dir][1];
        }
        return nodes;
    }

    private static boolean inRange(int r, int c) {
        return !(r < 0 || r >= n || c < 0 || c >= n);
    }
}