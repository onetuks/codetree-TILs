import java.util.*;

class Node {
    int i, j;

    Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Main {

    private static final int[][] DLIST = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    private static int n, r1, c1, r2, c2;
    private static int[][] matrix;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();
        
        matrix = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i ++)
            for (int j = 1; j <= n; j ++)
                matrix[i][j] = Integer.MAX_VALUE;

        bfs();

        if (matrix[r2][c2] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(matrix[r2][c2]);
        }
    }

    private static void bfs() {
        Queue<Node> q = new ArrayDeque<>();

        q.add(new Node(r1, c1));
        matrix[r1][c1] = 0;
        
        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.i == r2 && node.j == c2) break;

            for (int[] d: DLIST) {
                int di = node.i + d[0];
                int dj = node.j + d[1];
                if (di <= 0 || di > n || dj <= 0 || dj > n) continue;
                if (matrix[node.i][node.j] + 1 >= matrix[di][dj]) continue;
                matrix[di][dj] = matrix[node.i][node.j] + 1;
                q.add(new Node(di, dj));
            }
        }
    }
}