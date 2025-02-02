import java.util.*;
import java.io.*;

public class Main {

    private static List<Character> expression = new ArrayList<>();
    private static Map<Character, Integer> map = new HashMap<>();

    private static List<Character> scheme = new ArrayList<>();
    private static List<Integer> list = new ArrayList<>();

    private static int n = 0;
    private static long answer = Long.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Character> operands = new ArrayList<>();

        String[] tokens = sc.nextLine().split("");
        for (String token: tokens) {
            char t = token.charAt(0);
            expression.add(t);
            if (isOperator(t)) continue;
            operands.add(t);
            map.put(t, -1);
        }

        for (char key: map.keySet())
            scheme.add(key);
        n = scheme.size();
            
        combinations(0);

        System.out.println(answer);
    }

    private static void combinations(int idx) {
        if (idx == n) {
            bindValue();
            calculate();
            return;
        }
        for (int i = 1; i <= 4; i ++) {
            list.add(i);
            combinations(idx + 1);
            list.remove(list.size() - 1);
        }
    }

    private static boolean isOperator(char t) {
        return (t == '+' || t == '-' || t == '*');
    }

    private static void calculate() {
        int idx = 0;
        long result = map.get(expression.get(idx++));
        while (idx < expression.size()) {
            char operator = expression.get(idx++);
            char operand = expression.get(idx++);
            int value = map.get(operand);
            
            if (operator == '+') result += value;
            else if (operator == '-') result -= value;
            else result *= value;
        }
        answer = Math.max(answer, result);
    }

    private static void bindValue() {
        for (int i = 0; i < n; i ++)
            map.put(scheme.get(i), list.get(i));

        // for (char key: map.keySet())
        //     System.out.print("{" + key + ":" + map.get(key) + "}");
        // System.out.println();
    }
}