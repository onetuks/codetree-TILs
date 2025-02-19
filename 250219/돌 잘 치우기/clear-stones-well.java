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

    private static int n, k, m;
    private static int[][] matrix;
    private static boolean[][] visited;
    private static List<Node> allStones = new ArrayList<>();
    private static List<Node> eleminates = new ArrayList<>();
    private static List<Node> startPoints = new ArrayList<>();

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][n];
        for (int i = 0;i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] == 1)
                    allStones.add(new Node(i, j));
            }
        }

        for (int i = 0; i < k; i ++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            Node start = new Node(x, y);
            startPoints.add(start);
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int cnt, int idx) {
        if (cnt == m) {
            bfs();
            return;
        }

        for (int i = idx; i < allStones.size(); i ++) {
            eleminates.add(allStones.get(i));
            dfs(cnt + 1, idx + 1);
            eleminates.remove(eleminates.size() - 1);
        }
    }

    private static void bfs() {
        int count = 0;

        elemenateStones();

        Queue<Node> q = new ArrayDeque<>();
        visited = new boolean[n][n];

        for (Node start: startPoints) {
            if (eleminates.contains(start)) continue;
            q.add(start);
            visited[start.i][start.j] = true;
            count++;
        }

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int[] d: DLIST) {
                int di = node.i + d[0];
                int dj = node.j + d[1];
                if (di < 0 || di >= n || dj < 0  || dj >= n) continue;
                if (visited[di][dj] || matrix[di][dj] != 0) continue;
                visited[di][dj] = true;
                q.add(new Node(di, dj));
                count++;
            }
        }

        answer = Math.max(answer, count);

        restoreStones();
    }

    private static void elemenateStones() {
        for (Node node: eleminates) {
            matrix[node.i][node.j] = 0;
        }
    }

    private static void restoreStones() {
        for (Node node: eleminates) {
            matrix[node.i][node.j] = 1;
        }
    }
}