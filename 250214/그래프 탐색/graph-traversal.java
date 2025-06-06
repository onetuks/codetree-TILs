import java.util.*;
import java.io.*;

public class Main {

    private static int n, m;
    private static List<Integer>[] adj;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];

        adj = new List[n + 1];
        for (int i = 0; i <= n; i ++)
            adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i ++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }

        visited[1] = true;
        dfs(1);

        int answer = 0;
        for (boolean v: visited) {
            if (v) answer++;
        }
        System.out.print(answer - 1);
    }

    private static void dfs(int node) {
        for (int next: adj[node]) {
            if (visited[next]) continue;
            visited[next] = true;
            dfs(next);
        }
    }
}