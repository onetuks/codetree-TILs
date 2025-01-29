import java.util.*;
import java.io.*;

class Pair {
    int s;
    int e;

    Pair(int s, int e) {
        this.s = s;
        this.e = e;
    }
}

public class Main {

    private static int n;
    private static int answer = 0;
    private static List<Pair> pairs = new ArrayList<>();
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i ++) {
            pairs.add(new Pair(sc.nextInt(), sc.nextInt()));
        }
        pairs.sort((a, b) -> a.s - b.s);

        for (int i = 0; i < n; i ++) {
            list.add(i);
            calc(i);
            list.remove(list.size() - 1);
        }

        System.out.println(answer);
    }

    private static void calc(int idx) {
        if (idx == n - 1) {
            answer = Math.max(answer, getCount());
            return;
        }

        for (int i = idx + 1; i < n; i ++) {
            Pair curr = pairs.get(idx);
            Pair next = pairs.get(i);

            if (curr.e < next.s) {
                list.add(i);
                calc(i);
                list.remove(list.size() - 1);
            }
        }
    }

    private static int getCount() {
        int count = 0;
        int dist = 0;
        for (int l: list) {
            Pair p = pairs.get(l);
            if (dist < p.s) {
                count++;
                dist = p.e;
            }
        }
        return count;
    }
}