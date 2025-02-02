import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair> {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p) {
        if (x != p.x) return x - p.x;
        return y - p.y;
    }
}

public class Main {

    private static int n, m;
    private static List<Pair> lines = new ArrayList<>();
    private static List<Pair> selectedLines = new ArrayList<>();
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < m; i ++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            lines.add(new Pair(b, a - 1));
        }

        Collections.sort(lines);

        buildLadderLines(0);

        System.out.println(answer);
    }

    private static void buildLadderLines(int cnt) {
        if (cnt == m) {
            if (isPossible())
                answer = Math.min(answer, (int) selectedLines.size());
            return;
        }

        selectedLines.add(lines.get(cnt));
        buildLadderLines(cnt + 1);
        selectedLines.remove(selectedLines.size() - 1);

        buildLadderLines(cnt + 1);
    }

    private static boolean isPossible() {
        int[] target = new int[n];
        int[] source = new int[n];
        for (int i = 0; i < n; i++)
            target[i] = source[i] = i;

        for (int i = 0; i < (int) lines.size(); i ++) {
            int j = lines.get(i).y;
            int temp = target[j];
            target[j] = target[j + 1];
            target[j + 1] = temp;
        }
        for (int i = 0; i < (int) selectedLines.size(); i ++) {
            int j = selectedLines.get(i).y;
            int temp = source[j];
            source[j] = source[j + 1];
            source[j + 1] = temp;
        }

        for (int i = 0; i < n; i++) {
            if (source[i] != target[i])
                return false;
        }
        return true;
    }
}
