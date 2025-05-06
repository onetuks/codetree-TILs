import java.util.*;

class Point implements Comparable<Point> {
    int x, v, idx;

    Point(int x, int v, int idx) {
        this.x = x;
        this.v = v;
        this.idx = idx;
    }

    @Override
    public int compareTo(Point p) {
        return this.x - p.x;
    }
}

public class Main {

    private static final int START = +1;
    private static final int END = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        int n = sc.nextInt();

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            points.add(new Point(a, START, i));
            points.add(new Point(b, END, i));
        }

        Collections.sort(points);
        
        Set<Integer> set = new HashSet<>();
        for (Point p: points) {
            if (p.v == START) {
                if (set.isEmpty()) {
                    answer += 1;
                }
                set.add(p.idx);
            } else {
                set.remove(p.idx);
            }
        }

        System.out.println(answer);
    }
}