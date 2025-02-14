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
        int answer = dfs(1);

        System.out.println(answer - 1);
    }

    private static int dfs(int node) {
        int cnt = 1;
        for (int next: adj[node]) {
            if (visited[next]) continue;
            visited[next] = true;
            cnt += dfs(next);
        }
        return cnt;
    }
}