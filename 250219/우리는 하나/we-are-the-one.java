import java.util.*;
import java.io.*;

class Node {
    int i, j;

    Node (int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Main {

    private static final int[][] DLIST = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    private static int n, k, u, d;
    private static int[][] matrix;
    private static boolean[][] visited;
    private static Queue<Node> q = new ArrayDeque<>();
    private static List<Node> cities = new ArrayList<>();

    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();

        matrix = new int[n][n];
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                matrix[i][j] = sc.nextInt();

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int x, int y) {
        if (cities.size() == k) {
            bfs();
            return;
        }

        for (int i = x; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (i == x && j < y) continue;
                cities.add(new Node(i, j));
                dfs(i, j);
                cities.remove(cities.size() - 1);
            }
        }
    }

    private static void bfs() {
        int count = 0;

        q.clear();
        visited = new boolean[n][n];
        
        for (Node city: cities) {
            visited[city.i][city.j] = true;
            q.add(city);
            count++;
        }

        while (!q.isEmpty()) {
            Node node = q.poll();
            int oVal = matrix[node.i][node.j];

            for (int[] D: DLIST) {
                int di = node.i + D[0];
                int dj = node.j + D[1];
                if (di < 0 || di >= n || dj < 0 || dj >= n) continue;
                if (visited[di][dj]) continue;
                int tVal = matrix[di][dj];
                int diff = Math.abs(tVal - oVal);
                if (diff < u || diff > d) continue;
                visited[di][dj] = true;
                q.add(new Node(di, dj));
                count++;
            }
        }

        answer = Math.max(answer, count);
    }
}