import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static int[][] dlist = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int m, n;
    private static int[][] matrix;
    private static int[][] colors;
    private static boolean[][] visited;
    private static List<int[]> points;

    public static void main(String[] args) {
        m = sc.nextInt();
        n = sc.nextInt();

        matrix = new int[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++)
                matrix[i][j] = sc.nextInt();
        }

        colors = new int[m][n];
        points = new ArrayList<>();
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                colors[i][j] = sc.nextInt();
                if (colors[i][j] == 1)
                    points.add(new int[]{i, j});
            }
        }

        int ans = bisearch();

        System.out.println(ans);
    }

    private static int bisearch() {
        int l = 0, r = (int) 1e9;
        int ans = r + 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (isPossible(mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            // System.out.printf("l, r, ans, p: %d %d %d %b\n", l, r, ans, isPossible(mid));
        }
        return ans;
    }

    private static boolean isPossible(int diff) {
        // for (int i = 0; i < points.size(); i ++) {
        //     int[] point = points.get(i);
        //     visited = new boolean[m][n];
        //     visited[point[0]][point[1]] = true;
        //     bfs(point, diff);
        //     for (int j = i + 1; j < points.size(); j ++) {
        //         int[] other = points.get(j);
        //         if (!visited[other[0]][other[1]]) {
        //             return false;
        //         }
        //     }
        // }
        // return true;
        int[] point = points.get(0);
        visited = new boolean[m][n];
        visited[point[0]][point[1]] = true;
        bfs(point, diff);
        for (int i = 0; i < points.size(); i ++) {
            int[] other = points.get(i);
            if (!visited[other[0]][other[1]]) {
                return false;
            }
        }
        return true;
    }

    private static void bfs(int[] init, int diff) {
        Queue<int[]> q = new LinkedList<>();
        q.add(init);
        visited[init[0]][init[1]] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int i = point[0], j = point[1];
            for (int[] d: dlist) {
                int di = i + d[0], dj = j + d[1];
                if (di < 0 || di >= m || dj < 0 || dj >= n) continue;
                if (!visited[di][dj] && Math.abs(matrix[di][dj] - matrix[i][j]) <= diff) {
                    visited[di][dj] = true;
                    q.add(new int[]{di, dj});
                }
            }
        }
    }
}