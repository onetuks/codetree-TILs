import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static List<Integer> blocks;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(sc.next());

        blocks = new ArrayList<>();

        for (int i = 0; i < n; i ++) {
            blocks.add(Integer.parseInt(sc.next()));
        }

        remove(Integer.parseInt(sc.next()), Integer.parseInt(sc.next()));
        remove(Integer.parseInt(sc.next()), Integer.parseInt(sc.next()));

        System.out.println(blocks.size());
        for (int block: blocks) {
            System.out.println(block);
        }
    }

    private static void remove(int s, int e) {
        s--;
        e--;
        
        List<Integer> temp = new ArrayList<>();
        
        for (int i = 0; i < blocks.size(); i ++) {
            if (s <= i && i <= e) continue;
            temp.add(blocks.get(i));
        }

        blocks = temp;
    }
}