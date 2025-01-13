import java.util.*;
import java.io.*;

class Pair {
    int x;
    int y;
    int d;
    
    Pair(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair p = (Pair) o;
        return this.x == p.x && this.y == p.y;
    }
}

public class Main {

    private static final int[][] dlist = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private static final Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('U', 0);
        put('L', 1);
        put('D', 2);
        put('R', 3);
    }};

    private static int t, n, m;
    private static int[][] matrix;
    private static List<Pair> pairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < t; tc ++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            pairs = new ArrayList<>();
            for (int i = 0; i < m; i ++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int d = map.get(st.nextToken().charAt(0));
                pairs.add(new Pair(x, y, d));
            }

            for (int i = 0; i <= n * 2; i ++) {
                moveAll();
            }

            int answer = 0;
            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < n; j ++) {
                    if (matrix[i][j] > 0) answer++;
                }
            }
            System.out.println(answer);
        }
    }

    private static void moveAll() {
        matrix = new int[n][n];
        List<Pair> temp = new ArrayList<>();

        for (Pair pair: pairs) {
            int d = pair.d;
            int di = pair.x + dlist[d][0];
            int dj = pair.y + dlist[d][1];
            if (di < 0 || di >= n || dj < 0 || dj >= n) {
                d = (d >= 2) ? (d - 2) : (d + 2);
                di = pair.x;
                dj = pair.y;
            }
            Pair nPair = new Pair(di, dj, d);
            matrix[di][dj]++;
            temp.add(nPair);
        }

        pairs.clear();
        for (Pair pair: temp) {
            if (matrix[pair.x][pair.y] == 1) {
                pairs.add(pair);
            }
        }
    }
}