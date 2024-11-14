import java.util.*;
import java.io.*;

public class Main {

    private static final int BOUND = 3;
    private static int[][] matrix;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int answer = 0;

            int n = Integer.parseInt(br.readLine());
            
            matrix = new int[n][n];
            for (int i = 0; i < n; i ++) {
                String[] temp = br.readLine().split(" ");
                for (int j = 0; j < n; j ++) {
                    matrix[i][j] = Integer.parseInt(temp[j]);
                }
            }

            for (int i = 0; i <= n - BOUND; i ++) {
                for (int j = 0; j <= n - BOUND; j ++) {
                    int count = 0;
                    for (int x = 0; x < BOUND; x ++) {
                        for (int y = 0; y < BOUND; y ++) {
                            if (matrix[i + x][j + y] == 1) {
                                count ++;
                            }
                        }
                    }
                    answer = Math.max(answer, count);
                }
            }

            System.out.println(answer);
        } catch (IOException e) {
            //
        }
    }
}