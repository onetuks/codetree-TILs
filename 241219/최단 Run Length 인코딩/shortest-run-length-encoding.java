import java.util.*;

public class Main {

    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] word = sc.nextLine().toCharArray();

        for (int i = 0; i < word.length; i ++) {
            word = shift(word);
            answer = Math.min(answer, getEncodedLength(word));
        }

        System.out.println(answer);
    }

    private static char[] shift(char[] word) {
        char[] shiftedWord = new char[word.length];

        for (int i = 1; i < word.length; i ++) {
            shiftedWord[i] = word[i - 1];
        }
        shiftedWord[0] = word[word.length - 1];
        return shiftedWord;
    }

    private static int getEncodedLength(char[] word) {
        StringBuilder sb = new StringBuilder();
        
        int cnt = 0;
        char chr = word[0];
        for (char w: word) {
            if (chr == w) {
                cnt++;
            } else {
                sb.append(chr);
                sb.append(cnt);
                cnt = 1;
                chr = w;
            }
        }
        if (cnt > 0) {
            sb.append(chr);
            sb.append(cnt);
        }

        return sb.length();
    }
}