import java.util.*;
import java.io.*;

public class Main {

    private static final int[][] dlist = {{-1, +1}, {-1, -1}, {+1, -1}, {+1, +1}};

    private static int n;
    private static int[][] matrix; 

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        matrix = new int[n][n];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                for (int k = 1; k < n; k ++)
                    for (int l = 1; l < n; l ++)
                        answer = Math.max(answer, getSum(i, j, k, l));


        System.out.println(answer);
    }

    private static int getSum(int i, int j, int k, int l) {
        int[] moveCount = {k, l, k, l};

        int sum = 0;

        for (int d = 0; d < dlist.length; d ++) {
            for (int cnt = 0; cnt < moveCount[d]; cnt ++) {
                i += dlist[d][0];
                j += dlist[d][1];

                if (i < 0 || i >= n || j < 0 || j >= n)
                    return 0;

                sum += matrix[i][j];
            }
        }

        return sum;
    }
}