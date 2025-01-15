import java.util.*;
import java.io.*;

class Coordination {
    int x;
    int y;

    Coordination(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordination c = (Coordination) o;
        return this.x == c.x && this.y == c.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "{x:"+this.x+" y:"+this.y+"}";
    }
}

class Bead {
    int i;
    int w;
    int d;
    Bead(int i, int w, int d) {
        this.i = i;
        this.w = w;
        this.d = d;
    }

    @Override
    public String toString() {
        return "{i:"+this.i+" w:"+this.w+" d:"+this.d+"}";
    }
}

public class Main {

    private static final int BOUND = 1000;
    private static final int LENGTH = 2 * 2 * BOUND;
    private static final int[][] DLIST = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final Map<Character, Integer> DMAP = new HashMap<Character, Integer>() {{
        put('U', 0);
        put('D', 1);
        put('R', 2);
        put('L', 3);
    }};

    private static int t, n;
    private static Map<Coordination, Bead> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            for (int i = 1; i <= n; i ++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) * 2;
                int y = Integer.parseInt(st.nextToken()) * 2;
                int w = Integer.parseInt(st.nextToken());
                int d = DMAP.get(st.nextToken().charAt(0));
                Coordination c = new Coordination(x, y);
                Bead bead = new Bead(i, w, d);
                map.put(c, bead);
            }

            int answer = -1;
            for (int i = 1; i <= 1000; i++) {
                if (existsCollision()) {
                    answer = i;
                }
            }
            System.out.println(answer);
        }
    }

    private static boolean existsCollision() {
        Map<Coordination, List<Bead>> temp = new HashMap<>();
        for (Coordination c: map.keySet()) {
            Bead b = map.get(c);
            int di = c.x + DLIST[b.d][0];
            int dj = c.y + DLIST[b.d][1];
            Coordination nc = new Coordination(di, dj);
            List<Bead> list = temp.getOrDefault(nc, new ArrayList<>());
            list.add(b);
            temp.put(nc, list);
        }

        boolean collision = false;
        map.clear();
        for (Coordination c: temp.keySet()) {
            List<Bead> beads = temp.get(c);
            if (beads.size() > 1) collision = true;
            beads.sort(Comparator
                .comparingInt((Bead bead) -> bead.w)
                .thenComparingInt((Bead bead) -> bead.i)
                .reversed());
            map.put(c, beads.get(0));
        }
        return collision;
    }
}
