import java.util.*;

enum Operation {
    SUBTRACT,
    ADD,
    DIV2,
    DIV3
}

public class Main {

    private static final int OPERATION_CNT = 4;

    private static int n;
    private static int answer;
    private static int[] visited;
    private static Deque<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        visited = new int[n * 2];
        for (int i = 0; i < n * 2; i ++) {
            visited[i] = Integer.MAX_VALUE;
        }
        
        push(n, 0);

        while (!q.isEmpty()) {
            int num = q.poll();

            for (int i = 0; i < OPERATION_CNT; i ++) {
                if (!isPossible(i, num)) {
                    continue;
                }

                int newNum = calculate(i, num);
                if (canGo(newNum)) {
                    push(newNum, visited[num] + 1);
                }
            }

            System.out.println(num);
            System.out.println(Arrays.toString(visited));

            answer = visited[1];
        }

        System.out.println(answer);
    }

    private static int calculate(int op, int num) {
        if (op == Operation.SUBTRACT.ordinal()) {
            return op - 1;
        } else if (op == Operation.ADD.ordinal()) {
            return op + 1;
        } else if (op == Operation.DIV2.ordinal()) {
            return op / 2;
        } else if (op == Operation.DIV3.ordinal()) {
            return op / 3;
        }
        return num;
    }

    private static boolean canGo(int num) {
        return 0 <= num && num < 2 * n;
    }

    private static boolean isPossible(int op, int num) {
        if (op == Operation.SUBTRACT.ordinal() || op == Operation.ADD.ordinal()) {
            return true;
        } else if (op == Operation.DIV2.ordinal()) {
            return num % 2 == 0;
        } else if (op == Operation.DIV3.ordinal()) {
            return num % 3 == 0;
        }
        return false;
    }

    private static void push(int num, int cnt) {
        if (cnt < visited[num]) {
            visited[num] = cnt;
            q.add(num);
        }
    }
}