import java.util.*;
import java.io.*;

public class Main {

    private static int n, m;
    private static List<Integer> bombs;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(sc.next());
        m = Integer.parseInt(sc.next());

        bombs = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            bombs.add(Integer.parseInt(sc.next()));
        }

        while (explosible()) {
            explode();
        }

        System.out.println(bombs.size());
        for (int bomb: bombs) System.out.println(bomb);
    }

    private static boolean explosible() {
        if (bombs.isEmpty()) return false;

        int cnt = 0, val = 0;
        for (int bomb: bombs) {
            if (val == bomb) {
                cnt++;
                if (cnt >= m) return true;
                continue;
            }
            cnt = 1;
            val = bomb;
        }

        return false;
    }

    private static void explode() {
        List<Integer> temp = new ArrayList<>();
        
        int cnt = 0, val = 0;
        for (int i = 0; i < bombs.size(); i ++) {
            if (bombs.get(i) == val) {
                cnt++;
                continue;
            }

            if (cnt < m) {
                for (int j = 0; j < cnt; j ++) {
                    temp.add(val);
                }
            }
            cnt = 1;
            val = bombs.get(i);
        }

        if (cnt < m) {
            for (int j = 0; j < cnt; j ++) {
                temp.add(val);
            }
        }

        bombs = temp;
    }
}