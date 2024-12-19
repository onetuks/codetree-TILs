import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static final int CW = 1;
    public static final int CCW = 0;
    public static final int DIR_NUM = 4;
    public static final int MAX_N = 100;
    
    public static int n;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int[][] temp = new int[MAX_N][MAX_N];
    
    public static void shift(int x, int y, int k, int l, int moveDir) {
        int[] dx;
        int[] dy;
        int[] moveNums;
        
        if(moveDir == CCW) {
            dx = new int[]{-1, -1, 1, 1};
            dy = new int[]{1, -1, -1, 1};
            moveNums = new int[]{k, l, k, l}; 
        }
        else {
            dx = new int[]{-1, -1, 1, 1};
            dy = new int[]{-1, 1, 1, -1};
            moveNums = new int[]{l, k, l, k};
        }
        
        // Step1. temp 배열에 grid 값을 복사합니다.
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                temp[i][j] = grid[i][j];
    
        // Step2. 기울어진 직사각형의 경계를 쭉 따라가면서
        //        숫자를 한 칸씩 밀었을 때의 결과를
        //        temp에 저장합니다.
        for(int d = 0; d < DIR_NUM; d++)
            for(int q = 0; q < moveNums[d]; q++) {
                int nx = x + dx[d], ny = y + dy[d];
                temp[nx][ny] = grid[x][y];
                x = nx; y = ny;
            }
        
        // Step3. temp값을 grid에 옮겨줍니다.
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = temp[i][j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) 
                grid[i][j] = sc.nextInt();
        
        int x, y, m1, m2, m3, m4, d;
        x = sc.nextInt();
        y = sc.nextInt();
        m1 = sc.nextInt();
        m2 = sc.nextInt();
        m3 = sc.nextInt();
        m4 = sc.nextInt();
        d = sc.nextInt();
        
        shift(x - 1, y - 1, m1, m2, d);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }
}