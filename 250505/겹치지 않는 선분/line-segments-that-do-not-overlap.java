import java.util.*;
import java.io.*;

public class Main {

    private static int answer = 0;

    private static int n;
    private static int[][] lines;
    private static int[] lArray;
    private static int[] rArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());

        lines = new int[n][2];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());

            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lines, (a, b) -> a[0] - b[0]);

        lArray = new int[n];
        rArray = new int[n];

        lArray[0] = lines[0][1];
        rArray[n-1] = lines[n-1][1];

        for (int i = 1; i < n; i ++) {
            lArray[i] = Math.max(lArray[i-1], lines[i][1]);
        }
        for (int i = n-2; i >= 0; i --) {
            rArray[i] = Math.min(rArray[i+1], lines[i][1]);
        }

        for (int i = 0; i < n; i ++) {
            if (i > 0 && lArray[i-1] >= lines[i][1]) continue;
            if (i < n-1 && rArray[i+1] <= lines[i][1]) continue;
            answer += 1;
        }

        System.out.println(answer);
    }
}