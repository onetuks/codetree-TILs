import java.util.*;

class Pair implements Comparable<Pair> {
    int number;
    int count;

    Pair(int number, int count) {
        this.number = number;
        this.count = count;
    }

    @Override
    public int compareTo(Pair o) {
        return this.number - o.number;
    }

    @Override
    public String toString() {
        return this.number + " " + this.count;
    }
}

public class Main {

    private static Scanner sc = new Scanner(System.in);
    
    private static int n;
    private static List<Pair> counter = new ArrayList<>();

    public static void main(String[] args) {
        int answer = 0;

        n = sc.nextInt();

        for (int i = 0; i < n; i ++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            counter.add(new Pair(y, x));
        }

        Collections.sort(counter);

        int i = 0;
        int j = n - 1;

        while (i <= j) {
            Pair iPair = counter.get(i);
            Pair jPair = counter.get(j);

            answer = Math.max(answer, jPair.number + iPair.number);

            if (iPair.count < jPair.count) {
                jPair.count -= iPair.count;
                iPair.count = 0;
                i ++;
            } else if (iPair.count > jPair.count) {
                iPair.count -= jPair.count;
                jPair.count = 0;
                j --;
            } else {
                i ++;
                j --;
            }
        }

        System.out.println(answer);
    }
}