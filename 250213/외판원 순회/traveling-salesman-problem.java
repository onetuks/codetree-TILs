import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[][] adj;
    private static boolean[] visited;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        adj = new int[n][n];
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                adj[i][j] = sc.nextInt();

        visited = new boolean[n];
        doTour(0, 0, 0);

        System.out.println(answer);
    }

    private static void doTour(int cnt, int curr, int sum) {
        if (cnt == n) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int next = 0; next < n; next++) {
            if (visited[next] || adj[curr][next] == 0) continue;
            if (next == 0 && cnt < n - 1) continue;

            visited[next] = true;
            doTour(cnt + 1, next, sum + adj[curr][next]);
            visited[next] = false;
        }
    }
}