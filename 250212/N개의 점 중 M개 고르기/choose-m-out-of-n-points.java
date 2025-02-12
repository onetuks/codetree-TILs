import java.util.*;
import java.io.*;

class Node {
    int x, y;

    Node (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    private static int n, m;
    private static List<Node> nodes = new ArrayList<>();
    private static List<Node> chosen = new ArrayList<>();
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i ++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Node node = new Node(x, y);
            nodes.add(node);
        }

        choose(0);

        System.out.println(answer);
    }

    private static void choose(int idx) {
        if (chosen.size() == m) {
            updateMinDist();
            return;
        }

        for (int i = idx; i < n; i ++) {
            chosen.add(nodes.get(i));
            choose(i + 1);
            chosen.remove(chosen.size() - 1);
        }
    }

    private static void updateMinDist() {
        for (int i = 0; i < n; i ++)
            for (int j = i + 1; j < n; j ++)
                answer = Math.min(answer, getDist(nodes.get(i), nodes.get(j)));
    }

    private static int getDist(Node node1, Node node2) {
        return (int) Math.pow(node1.x - node2.x, 2) + (int) Math.pow(node1.y - node2.y, 2);
    }
}