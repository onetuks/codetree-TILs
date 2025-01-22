import java.util.*;
import java.io.*;

class Bead {
    int i;
    int x;
    int y;
    int w;
    int d;

    Bead(int i, int x, int y, int w, int d) {
        this.i = i;
        this.x = x;
        this.y = y;
        this.w = w;
        this.d = d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bead b = (Bead) o;
        return b.x == this.x && b.y == this.y;
    }

    @Override
    public String toString() {
        return "{i:" + this.i + ",x:" + this.x + ",y:" + this.y + ",w:" + this.w + ",d:" + this.d + "}";
    }
}

public class Main {

    private static final int[][] dlist = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('U', 0);
        put('D', 1);
        put('R', 2);
        put('L', 3);
    }};

    private static int t, n;
    private static Bead[] beads;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            beads = new Bead[n];

            for (int l = 0; l < n; l ++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                int d = map.get(st.nextToken().charAt(0));

                Bead bead = new Bead(l, x, y, w, d);
                beads[l] = bead;
            }

            int answer = -1;
            for (int time = 1; time <= 2000; time ++) {
                if (moveAll()) 
                    answer = time * 2;
            }
            System.out.println(answer);
        }
    }

    private static boolean moveAll() {
        boolean result = false;
        Bead[] nBeads = new Bead[n];

        for (int i = 0; i < n; i ++) {
            if (beads[i] == null) continue;

            Bead iBead = move(beads[i]);
            nBeads[i] = iBead;
            boolean collision = false;

            for (int j = 0; j < n; j ++) {
                if (i == j) continue;

                Bead jBead = beads[j];
                Bead nBead = nBeads[j];

                if (Objects.equals(iBead, jBead)) {
                    collision = true;
                    result = true;
                    if (iBead.w > jBead.w || (iBead.w == jBead.w && iBead.i > jBead.i)) {
                        nBeads[j] = null;
                    } else {
                        nBeads[i] = null;
                        break;
                    }
                }
                if (Objects.equals(iBead, nBead)) {
                    collision = true;
                    result = true;
                    if (iBead.w > nBead.w || (iBead.w == nBead.w && iBead.i > nBead.i)) {
                        nBeads[j] = null;
                    } else {
                        nBeads[i] = null;
                        break;
                    }
                }
            }
        }

        beads = nBeads;

        return result;
    }

    private static Bead move(Bead bead) {
        return new Bead(
            bead.i,
            bead.x + dlist[bead.d][0],
            bead.y + dlist[bead.d][1],
            bead.w,
            bead.d
        );
    }
}
