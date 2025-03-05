import java.io.*;
import java.util.*;

class Node {
    int i, j;

    Node (int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Main {

    private static final int[][] DLIST = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private static int n, m;
    private static int[][] matrix;
    private static boolean[][] visited;
    private static int[][] steps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        visited = new boolean[n][m];
        steps = new int[n][m];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                steps[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs(0, 0);

        System.out.println(steps[n - 1][m - 1]);
    }

    private static void bfs(int i, int j) {
        Queue<Node> q = new ArrayDeque<>();

        steps[i][j] = 0;
        visited[i][j] = true;
        q.add(new Node(i, j));

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.i == n - 1 && node.j == m - 1)
                break;

            for (int[] d: DLIST) {
                int di = node.i + d[0];
                int dj = node.j + d[1];
                if (di < 0 || di >= n || dj < 0 || dj >= m) continue;
                if (visited[di][dj] || matrix[di][dj] == 0) continue;
                visited[di][dj] = true;
                q.add(new Node(di, dj));
                steps[di][dj] = Math.min(steps[di][dj], steps[node.i][node.j] + 1);
            }
        }
    }
}