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
            // // debug
            // for (int seq: sequence) System.out.print(seq + " " );
            // System.out.println(isImpossible());
            // // debug

            if (!isImpossible()) {
                StringBuilder sb = new StringBuilder();
                for (int seq: sequence)
                    sb.append(seq);
                answer = sb.toString();
            }
            return;
        }

        for (int i = 4; i <= 6; i ++) {
            sequence.add(i);
            makeSequence();
            sequence.remove(sequence.size() - 1);
        }
    }

    private static boolean isImpossible() {
        for (int tab = 1; tab <= n / 2; tab ++) {
            int idx = 0;
            while (idx <= n - tab * 2) {
                String preSub = buildSubString(idx, tab);
                String posSub = buildSubString(idx + tab, tab);
                // System.out.println(preSub + " " + posSub);
                if (Objects.equals(preSub, posSub))
                    return true;
                idx++;
            }
        }
        return false;
    }

    private static String buildSubString(int idx, int tab) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tab; i ++) {
            sb.append(sequence.get(i + idx));
        }
        return sb.toString();
    }
}