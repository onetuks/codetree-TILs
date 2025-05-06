import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    int x, v;

    Point(int x, int v) {
        this.x = x;
        this.v = v;
    }

    @Override
    public int compareTo(Point o) {
        return this.x - o.x;
    }
}

public class Main {

    private static final int START = +1;
    private static final int END = -1;

    private static int answer = 0;
    private static int n;
    private static List<Point> points = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            points.add(new Point(x1, START));
            points.add(new Point(x2, END));
        }

        Collections.sort(points);

        int sumVal = 0;
        for (int i = 0; i < 2 * n; i++) {
            int x = points.get(i).x;
            int v = points.get(i).v;

            sumVal += v;

            answer = Math.max(answer, sumVal);
        }

        System.out.println(answer);
    }
}