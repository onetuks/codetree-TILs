import java.util.*;
import java.io.*;

class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    private static final int[][] dlist = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    private static int n, m;
    private static Deque<Integer>[][] matrix;
    private static Map<Integer, Pair> map;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        matrix = new ArrayDeque[n][n];
        map = new HashMap<>();

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                int num = sc.nextInt();
                matrix[i][j] = new ArrayDeque<>();
                matrix[i][j].add(num);
                map.put(num, new Pair(i, j));
            }
        }

        while (m-- > 0) {
            int num = sc.nextInt();
            Pair pair = map.get(num);
            
            int i = pair.x, j = pair.y;
            int ti = i, tj = j;
            int maxVal = -1;
            for (int[] d: dlist) {
                int di = i + d[0];
                int dj = j + d[1];
                if (di < 0 || di >= n || dj < 0 || dj >= n) continue;
                Deque<Integer> vals = matrix[di][dj];
                for (int val: vals) {
                    if (val > maxVal) {
                        maxVal = val;
                        ti = di;
                        tj = dj;
                    }
                }
            }

            if (i == ti && j == tj) continue;

            List<Integer> temp = new ArrayList<>();
            for (int val: matrix[i][j]) {
                temp.add(val);
                if (val == num) break;
            }
            Collections.reverse(temp);
            for (int val: temp) {
                matrix[i][j].remove(val);
                matrix[ti][tj].addFirst(val);
                map.put(val, new Pair(ti, tj));
            }
        }

        print();
    }

    private static void print() {
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j].isEmpty()) {
                    System.out.println("None");
                    continue;
                }

                for (int val: matrix[i][j]) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }
    }
}