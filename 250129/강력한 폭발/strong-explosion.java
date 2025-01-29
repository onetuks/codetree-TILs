import java.util.*;
import java.io.*;

class Pair {
    int i;
    int j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Main {

    private static int n;
    private static List<Pair> pairs = new ArrayList<>();
    private static boolean[][] field;
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                if (sc.nextInt() == 1) {
                    pairs.add(new Pair(i, j));
                }
            }
        }

        explode(new ArrayList<>());

        System.out.println(answer);
    }

    private static void explode(List<Integer> bombs) {
        if (bombs.size() == pairs.size()) {
            countEffect(bombs);
            return;
        }
        for (int bomb = 1; bomb <= 3; bomb ++) {
            bombs.add(bomb);
            explode(bombs);
            bombs.remove(bombs.size() - 1);
        }
    }

    private static void countEffect(List<Integer> bombs) {
        field = new boolean[n][n];
        int count = 0;

        for (int i = 0; i < bombs.size(); i ++) {
            Pair p = pairs.get(i);
            int b = bombs.get(i);

            if (b == 1) explode1(p.i, p.j);
            else if (b == 2) explode2(p.i, p.j);
            else explode3(p.i, p.j);
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (field[i][j]) count++;
            }
        }

        // // debug
        // for (int bomb: bombs) System.out.print(bomb + " ");
        // System.out.println();
        // for (int i = 0; i < n; i ++) {
        //     System.out.println(Arrays.toString(field[i]));
        // }
        // System.out.println();
        // // debug

        answer = Math.max(answer, count);
    }

    private static void explode1(int x, int y) {
        for (int i = 0; i < 3; i ++) {
            if (x - i >= 0) field[x - i][y] = true;
            if (x + i < n) field[x + i][y] = true;
        }
    }

    private static void explode2(int x, int y) {
        for (int i = 0; i < 2; i ++) {
            if (y - i >= 0) field[x][y - i] = true;
            if (y + i < n) field[x][y + i] = true;
            if (x - i >= 0) field[x - i][y] = true;
            if (x + i < n) field[x + i][y] = true;
        }
    }

    private static void explode3(int x, int y) {
        for (int i = 0; i < 2; i ++) {
            if (x - i >= 0 && y - i >= 0) field[x - i][y - i] = true;
            if (x - i >= 0 && y + i < n) field[x - i][y + i] = true;
            if (x + i < n && y - i >= 0) field[x + i][y - i] = true;
            if (x + i < n && y + i < n) field[x + i][y + i] = true;
        }
    }
}