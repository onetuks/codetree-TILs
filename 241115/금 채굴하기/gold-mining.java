import java.util.*;
import java.io.*;

public class Main {

    private static final int[][] dlist = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int n, m;
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        int answer = 0;

        setup();

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                for (int k = 0; k <= n; k ++) {
                    int count = getCount(i, j, k);
                    // if (i >= 2)
                    //     System.out.printf("i:%d j:%d k:%d c:%d\n", i, j, k, count);
                    answer = Math.max(answer, count);
                }
            }
        }

        System.out.println(answer);
    }

    private static int getCount(int x, int y, int k) {
        int goldCount = 0; 
        int gridCount = k * k + (k + 1) * (k + 1);
        
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        
        visited[x][y] = true;
        q.add(new int[]{0, x, y});

        while (!q.isEmpty()) {
            int[] loc = q.poll();
            if (matrix[loc[1]][loc[2]] == 1)
                goldCount ++;
            if (loc[0] >= k)
                continue;
            for (int[] d: dlist) {
                int di = loc[1] + d[0], dj = loc[2] + d[1];
                if (di < 0 || di >= n || dj < 0 || dj >= n || visited[di][dj]) {
                    continue;
                }
                q.add(new int[]{loc[0] + 1, di, dj});
                visited[di][dj] = true;
            }
        }

        if (goldCount * m > gridCount) {
            return goldCount;
        }
        return 0;
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][n];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}