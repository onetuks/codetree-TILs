import java.util.*;

class Point implements Comparable<Point> {
    int x, v;

    Point(int x, int v) {
        this.x = x;
        this.v = v;
    }

    @Override
    public int compareTo(Point p) {
        return this.x - p.x;
    }

    @Override
    public String toString() {
        return "{" + this.x  + "," + this.v + "}";
    }
}

public class Main {

    private static final int START = +1;
    private static final int END = -1;

    private static int n;
    private static List<Point> points = new ArrayList<>();

    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            points.add(new Point(x1, START));
            points.add(new Point(x2, END));
        }

        Collections.sort(points);
        
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < points.size(); i ++) {
            count += points.get(i).v;
            if (count > maxCount) {
                maxCount = count;
            }
        }

        System.out.println(maxCount);
    }
}