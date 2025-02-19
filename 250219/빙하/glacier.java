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

    private static int n, m;
    private static int[][] matrix;
    private static boolean[][] effect;
    
    private static int finalMeltingTime = 0;
    private static int finalIcebergCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] == 1) finalIcebergCount++;
            }
        }

        while (true) {
            finalMeltingTime++;
            int meltedCount = melt();
            if (finalIcebergCount - meltedCount <= 0) break;
            finalIcebergCount -= meltedCount;
        }

        System.out.println(finalMeltingTime + " " + finalIcebergCount);
    }

    private static void dfs(int i, int j) {
        for (int[] d: DLIST) {
            int di = i + d[0];
            int dj = j + d[1];
            if (di < 0 || di >= n || dj < 0 || dj >= m) continue;
            if (effect[di][dj] || matrix[di][dj] > 0) continue;
            effect[di][dj] = true;
            dfs(di, dj);
        }
    }

    private static int melt() {
        Queue<Node> q = new ArrayDeque<>();
        int count = 0;

        effect = new boolean[n][m];
        dfs(0, 0);

        for (int i = 0; i < n; i ++)
            for (int j = 0; j < m; j++)
                if (isEffectableIceberg(i, j))
                    q.add(new Node(i, j));

        while (!q.isEmpty()) {
            Node node = q.poll();
            
            for (int[] d: DLIST) {
                int di = node.i + d[0];
                int dj = node.j + d[1];
                if (di < 0 || di >= n || dj < 0 || dj >= m) continue;
                if (matrix[di][dj] == 0) continue;
                matrix[di][dj] = 0;
                count++;
            }
        }

        return count;
    }

    private static boolean isEffectableIceberg(int i, int j) {
        if (matrix[i][j] == 1 || !effect[i][j]) 
            return false;

        int neighborIcebergCnt = 0, neighborWaterCnt = 0;
        for (int[] d: DLIST) {
            int di = i + d[0];
            int dj = j + d[1];
            if (di < 0 || di >= n || dj < 0 || dj >= m) continue;
            if (matrix[di][dj] == 0) neighborWaterCnt++;
            else neighborIcebergCnt++;
        }
        
        return (neighborIcebergCnt > 0) && (neighborWaterCnt > 0);
    }
}