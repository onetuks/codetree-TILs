import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int i, j, val;

    Node(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }

    @Override
    public int compareTo(Node o) {
        if (this.val != o.val) return o.val - this.val;
        if (this.i != o.i) return this.i - o.i;
        return this.j - o.j;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Node n = (Node) o;
        return this.i == n.i && this.j == n.j && this.val == n.val;
    }

    @Override
    public String toString() {
        return (i + 1) + " " + (j + 1);
    }
}

public class Main {

    private static final int[][] DLIST = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private static int n, k;
    private static int[][] matrix;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j =0; j < n;j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        Node node = new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);

        for (int i = 0; i < k; i ++) {
            Node next = bfs(node);
            if (node == next) break;
            node = next;
        }

        System.out.println(node);
    }

    private static Node bfs(Node start) {
        Queue<Node> q = new ArrayDeque<>();
        visited = new boolean[n][n];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        q.add(start);
        visited[start.i][start.j] = true;

        int val = matrix[start.i][start.j];

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int[] d: DLIST) {
                int di = node.i + d[0];
                int dj = node.j + d[1];
                if (di < 0 || di >= n || dj < 0 || dj >= n) continue;
                if (visited[di][dj] || matrix[di][dj] >= val) continue;
                visited[di][dj] = true;
                Node next = new Node(di, dj, matrix[di][dj]);
                q.add(next);
                pq.add(next);
            }
        }

        if (pq.isEmpty()) {
            return start;
        }
        return pq.poll();
    }
}