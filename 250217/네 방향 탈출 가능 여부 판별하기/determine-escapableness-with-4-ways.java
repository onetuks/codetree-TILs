import java.util.*;
import java.io.*;

class Node {
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    private static final int[][] DLIST = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private static int n, m;
    private static int[][] matrix;
    private static boolean[][] visited;

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m;j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        searchPath();

        System.out.println(answer);
    }

    private static void searchPath() {
        Queue<Node> q = new ArrayDeque<>();
        visited = new boolean[n][m];

        q.add(new Node(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.x == n - 1 && node.y == m - 1) {
                answer = 1;
                break;
            }

            for (int[] d: DLIST) {
                int di = node.x + d[0];
                int dj = node.y + d[1];
                if (di < 0 || di >= n || dj < 0 || dj >= m) continue;
                if (visited[di][dj] || matrix[di][dj] != 1) continue;
                visited[di][dj] = true;
                q.add(new Node(di, dj));
            }
        }
    }
}