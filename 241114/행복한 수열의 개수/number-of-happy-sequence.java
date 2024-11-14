import java.io.*;
import java.util.*;

public class Main {

    private static int n, m;
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][n]; 
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j ++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // calculate with row
        for (int i = 0; i < n; i ++) {
            Map<Integer, Integer> map = new HashMap<>();
            int num = 0;
            for (int j = 0; j < n; j ++) {
                if (num == matrix[i][j]) {
                    map.put(num, map.get(num) + 1);
                } else {
                    num = matrix[i][j];
                    map.put(num, map.getOrDefault(num, 1));
                    
                }
            }
            for (int val: map.values()) {
                if (val >= m)
                    ans ++;
            }
        }

        // calculate with col
        for (int j = 0; j < n; j ++) {
            Map<Integer, Integer> map = new HashMap<>();
            int num = 0;
            for (int i = 0; i < n; i ++) {
                if (num == matrix[i][j]) {
                    map.put(num, map.get(num) + 1);
                } else {
                    num = matrix[i][j];
                    map.put(num, map.getOrDefault(num, 1));
                }
            }
            
            for (int val: map.values()) {
                if (val >= m)
                    ans ++;
            }
        }

        System.out.println(ans);
    }
}