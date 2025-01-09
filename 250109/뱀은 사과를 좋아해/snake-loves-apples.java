import java.util.*;
import java.io.*;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    boolean isOutOfRange(int n) {
        return this.x < 0 || this.x >= n || this.y < 0 || this.y >= n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair other = (Pair) o;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public String toString() {
        return "x:" + this.x + " y:" + this.y;
    }
}

public class Main {
    private static final int[][] dlist = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('R', 0);
        put('L', 1);
        put('D', 2);
        put('U', 3);
    }};

    private static int n, m, k;
    private static int[][] matrix;
    private static Deque<Pair> deque;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        matrix = new int[n][n];

        for (int i = 0; i < m; i ++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            matrix[x][y] = 1;
        }

        deque = new ArrayDeque<>();
        deque.addFirst(new Pair(0, 0));

        int answer = 0;

        for (int l = 0; l < k; l ++) {
            int d = map.get(sc.next().charAt(0));
            int p = sc.nextInt();
            boolean flag = false;

            for (int i = 0; i < p; i ++) {
                answer++;

                Pair head = deque.peekFirst();
                Pair nextHead = new Pair(head.x + dlist[d][0], head.y + dlist[d][1]);

                if (nextHead.isOutOfRange(n)) {
                    flag = true; // 커맨드 별로 횟수가 있으므로, 플래그 변수로 종료조건 시 프로그램 자체를 멈춰야 함
                    break;
                }
                if (matrix[nextHead.x][nextHead.y] != 1) deque.pollLast();
                if (deque.contains(nextHead)) {
                    flag = true;
                    break;
                }

                matrix[nextHead.x][nextHead.y] = 0; // 이미 먹은 사과는 제거해야함
                deque.addFirst(nextHead);
            }

            if (flag) break;
        }

        System.out.println(answer);
    }
}