import java.util.*;
import java.io.*;

class Bead {
    int i;
    int w;
    int d;

    Bead(int i, int w, int d) {
        this.i = i;
        this.w = w;
        this.d = d;
    }

    Bead bounceOut() {
        return new Bead(
            this.i,
            this.w,
            this.d % 2 == 0
                ? this.d + 1
                : this.d - 1 
        );
    }

    static Bead merge(Bead b1, Bead b2) {
        return new Bead(
            Math.max(b1.i, b2.i),
            b1.w + b2.w,
            b1.i > b2.i ? b1.d : b2.d
        );
    }

    @Override
    public String toString() {
        return "{i:" + this.i + " w:" + this.w + " d:" + this.d + "}";
    }
}

public class Main {

    private static final int[][] DLIST = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static final Map<Character, Integer> DMAP = new HashMap<Character, Integer>() {{
        put('U', 0);
        put('D', 1);
        put('R', 2);
        put('L', 3);
    }};

    private static int n, m, t;
    private static Bead[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        matrix = new Bead[n][n];

        for (int i = 0; i < m; i ++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = DMAP.get(st.nextToken().charAt(0));
            int w = Integer.parseInt(st.nextToken());
            matrix[r][c] = new Bead(i, w, d);
        }

        while (t-- > 0) {
            moveAllBeads();
        }

        int beadCount = 0;
        int maxWeight = Integer.MIN_VALUE;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == null) continue;
                beadCount++;
                maxWeight = Math.max(maxWeight, matrix[i][j].w);
            }
        }

        System.out.println(beadCount + " " + maxWeight);
    }

    private static void moveAllBeads() {
        Bead[][] temp = new Bead[n][n];

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == null) continue;

                Bead bead = matrix[i][j];
                int di = i + DLIST[bead.d][0];
                int dj = j + DLIST[bead.d][1];

                if (di < 0 || di >= n || dj < 0 || dj >= n) {
                    temp[i][j] = bead.bounceOut();
                    continue;
                }

                if (temp[di][dj] == null) {
                    temp[di][dj] = bead;
                    continue;
                }
                
                temp[di][dj] = Bead.merge(bead, temp[di][dj]);
            }
        }

        matrix = temp;
    }
}