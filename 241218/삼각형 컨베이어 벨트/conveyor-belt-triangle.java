import java.util.*;
import java.io.*;

public class Main {
    
    private static int n, t;
    private static int[] matrix;

    public static void main(String[] args) {
        setup();

        for (int i = 0; i < t; i ++) {
            rotate();
        }

        print();
    }

    private static void rotate() {
        int temp = matrix[n * 3 - 1];
        for (int i = n * 3 - 1; i > 0; i --) {
            matrix[i] = matrix[i - 1];
        }
        matrix[0] = temp;
    }

    private static void setup() {
        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(sc.next());
        t = Integer.parseInt(sc.next());

        matrix = new int[n * 3];
        for (int i = 0; i < n * 3; i ++) {
            matrix[i] = Integer.parseInt(sc.next());
        }
    }

    private static void print() {
        for (int i = 0; i < matrix.length; i ++) {
            if (i % 3 == 0 && i != 0)
                System.out.println();
            System.out.print(matrix[i] + " ");
        }
    }
}
