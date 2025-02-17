import java.util.*;
import java.io.*;

class Node {
    int i, j;

    Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Main {

    private static final int[][] DLIST = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private static int n, k;
    private static int[][] matrix;
    private static boolean[][] visited;
    private static Queue<Node> q = new ArrayDeque<>();

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[n][n];
        matrix = new int[n][n];
        for (int i = 0;i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i ++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            visited[x][y] = true;
            q.add(new Node(x, y));
        }

        bfs();

        System.out.println(answer);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Node node = q.poll();

            answer++;

            for (int[] d: DLIST) {
                int di = node.i + d[0];
                int dj = node.j + d[1];
                if (di < 0 || di >= n || dj < 0 || dj >= n) continue;
                if (visited[di][dj] || matrix[di][dj] != 0) continue;
                visited[di][dj] = true;
                q.add(new Node(di, dj));
            }
        }
    }
}