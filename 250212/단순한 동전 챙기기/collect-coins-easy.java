import java.util.*;
import java.io.*;

class Node {
    int i, j;

    Node(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getDist(Node node) {
        return Math.abs(this.i - node.i) + Math.abs(this.j - node.j);
    }

    @Override
    public String toString() {
        return "{" + i + "," + j + "}";
    }
}

public class Main {

    private static final int M_SIZE = 3;

    private static int n;
    private static Map<Character, Node> map = new HashMap<>();
    private static List<Character> nodes = new ArrayList<>();
    private static List<Character> list = new ArrayList<>();
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        
        for (int i = 0; i < n; i ++) {
            String line = sc.next();
            for (int j = 0; j < n; j ++) {
                if (line.charAt(j) == '.') continue;
                map.put(line.charAt(j), new Node(i, j));
            }
        }

        Set<Character> keys = map.keySet();
        for (char key: keys) {
            if (key == 'S' || key == 'E') 
                continue;
            nodes.add(key); 
        }

        if (nodes.size() < M_SIZE) {
            System.out.println(-1);
            System.exit(0);
        }

        combinations(0);

        System.out.println(answer);
    }

    private static void combinations(int idx) {
        if (list.size() == M_SIZE) {
            answer = Math.min(answer, getTotalDist());
            return;
        }

        for (int i = idx; i < nodes.size(); i ++) {
            list.add(nodes.get(i));
            combinations(i + 1);
            list.remove(list.size() - 1);
        }
    }

    private static int getTotalDist() {
        int dist = 0;
        Node curr = map.get('S');
        for (char num: list) {
            Node next = map.get(num);
            dist += curr.getDist(next);
            curr = next;
        }
        dist += curr.getDist(map.get('E'));
        return dist;
    }
}