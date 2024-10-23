import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static int n;

    public static void main(String[] args) {
        n = sc.nextInt();

        List<Integer> aCards = new ArrayList<>();
        List<Integer> bCards = new ArrayList<>();

        for (int i = 0; i < n; i ++) {
            bCards.add(sc.nextInt());
        }

        for (int i = 1; i <= 2 * n; i ++) {
            if (!bCards.contains(i)) {
                aCards.add(i);
            }
        }

        Collections.sort(aCards);
        Collections.sort(bCards, Collections.reverseOrder());

        int i = 0;
        int j = n - 1;

        int ans = 0;

        for (int b: bCards) {
            if (b < aCards.get(j)) {
                j--;
                ans++;
            } else {
                i++;
            }
        }

        System.out.println(ans);
    }
}