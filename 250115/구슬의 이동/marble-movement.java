import java.util.*;
import java.io.*;

class Perl {
    int i;
    int x;
    int y;
    int d;
    int v;

    Perl(int i, int x, int y, int d, int v) {
        this.i = i;
        this.x = x;
        this.y = y;
        this.d = d;
        this.v = v;
    }
}

public class Main {

    private static final int[][] dlist = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static final Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('U', 0);
        put('D', 1);
        put('R', 2);
        put('L', 3);
    }};

    private static int n, m, t, k;
    private static Map<Integer, Perl> perls;
    private static int[][] matrix;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        perls = new HashMap<>();
        for (int i = 1; i <= m; i ++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = map.get(st.nextToken().charAt(0));
            int v = Integer.parseInt(st.nextToken());
            Perl perl = new Perl(i, x, y, d, v);
            perls.put(i, perl);
        }

        while (t-- > 0) {
            moveAll();
        }

        System.out.println(perls.size());
    }

    private static void moveAll() {
        matrix = new int[n][n];

        for (int idx: perls.keySet()) {
            Perl p = perls.get(idx);
            for (int l = 0; l < p.v; l ++) {
                int di = p.x + dlist[p.d][0];
                int dj = p.y + dlist[p.d][1];
                if (di < 0 || di >= n || dj < 0 || dj >= n) {
                    p.d = (p.d % 2 == 0) ? (p.d + 1) : (p.d - 1);
                    di = p.x + dlist[p.d][0];
                    dj = p.y + dlist[p.d][1];
                }
                p.x = di;
                p.y = dj;
            }
            perls.put(idx, p);
            matrix[p.x][p.y]++;
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] > k) {
                    List<Perl> temps = new ArrayList<>();
                    for (Perl p: perls.values()) {
                        if (p.x == i && p.y == j) 
                            temps.add(p);
                    }

                    temps.sort(Comparator
                        .comparingInt((Perl perl) -> perl.v)
                        .thenComparingInt((Perl perl) -> perl.i));

                    int idx = 0;
                    while (matrix[i][j] > k) {
                        perls.remove(temps.get(idx).i);
                        matrix[i][j]--;
                    }
                }
            }
        }
    }
}