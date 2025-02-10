import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static List<Integer> sequence = new ArrayList<>();
    private static String answer = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        makeSequence();

        System.out.println(answer);
    }

    private static void makeSequence() {
        if (answer != null) return;
        if (sequence.size() == n) {
            if (!isImpossible()) {
                StringBuilder sb = new StringBuilder();
                for (int seq: sequence)
                    sb.append(seq);
                answer = sb.toString();
            }
            return;
        }

        if (isImpossible()) return;

        for (int i = 4; i <= 6; i ++) {
            sequence.add(i);
            makeSequence();
            sequence.remove(sequence.size() - 1);
        }
    }

    private static boolean isImpossible() {
        for (int tab = 1; tab <= sequence.size() / 2; tab ++) {
            int idx = 0;
            while (idx <= sequence.size() - tab * 2) {
                int[] preSub = buildSubArray(idx, tab);
                int[] posSub = buildSubArray(idx + tab, tab);
                if (isSame(preSub, posSub))
                    return true;
                idx++;
            }
        }
        return false;
    }

    private static int[] buildSubArray(int idx, int tab) {
        int[] sub = new int[tab];
        for (int i = 0; i < tab; i ++)
            sub[i] = sequence.get(i + idx);
        return sub;
    }

    private static boolean isSame(int[] pre, int[] pos) {
        for (int i = 0; i < pre.length; i ++) {
            if (pre[i] != pos[i])
                return false;
        }
        return true;
    }
}
