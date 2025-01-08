import java.util.*;
import java.io.*;

class Dice {
    int top;
    int bottom;
    int left;
    int right;
    int front;
    int rear;

    Dice() {
        this.top = 1;
        this.bottom = 6;
        this.left = 4;
        this.right = 3;
        this.front = 2;
        this.rear = 5;
    }

    Dice(int top, int bottom, int left, int right, int front, int rear) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
        this.front = front;
        this.rear = rear;
    }

    Dice left() {
        return new Dice(this.right, this.left, this.top, this.bottom, this.front, this.rear);
    }

    Dice right() {
        return new Dice(this.left, this.right, this.bottom, this.top, this.front, this.rear);
    }

    Dice up() {
        return new Dice(this.front, this.rear, this.left, this.right, this.bottom, this.top);
    }

    Dice down() {
        return new Dice(this.rear, this.front, this.left, this.right, this.top, this.bottom);
    }

    @Override
    public String toString() {
        return "t:" + this.top + " b:" + this.bottom + " l:" + this.left + " r:" + this.right + " f:" + this.front + " r:" + this.rear;
    }
}

public class Main {

    private static final int[][] dlist = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private static final Map<Character, Integer> map = new HashMap<>();

    private static int n, m, r, c;
    private static int[][] matrix;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map.put('L', 0);
        map.put('R', 1);
        map.put('U', 2);
        map.put('D', 3);

        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;

        Dice dice = new Dice();

        matrix = new int[n][n];
        matrix[r][c] = dice.bottom;

        for (int i = 0; i < m; i ++) {
            char d = sc.next().charAt(0);
            int dir = map.get(d);
            int di = r + dlist[dir][0];
            int dj = c + dlist[dir][1];
            if (di < 0 || di >= n || dj < 0 || dj >= n) continue;

            r = di;
            c = dj;

            if (d == 'L') dice = dice.left();
            else if (d == 'R') dice = dice.right();
            else if (d == 'U') dice = dice.up();
            else dice = dice.down();

            matrix[r][c] = dice.bottom;
        }

        int answer = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++)  {
                answer += matrix[i][j];
            }
        }
        System.out.println(answer);
    }
}