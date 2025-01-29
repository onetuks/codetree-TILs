import java.util.*;
import java.io.*;

class Section {
    int s;
    int e;

    Section(int s, int e) {
        this.s = s;
        this.e = e;
    }
}

public class Main {

    private static int n;
    private static List<Section> sections = new ArrayList<>();
    private static List<Integer> list = new ArrayList<>();
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i ++) {
            Section section = new Section(sc.nextInt(), sc.nextInt());
            sections.add(section);
        }

        calc();

        System.out.println(answer);
    }

    private static void calc() {
        if (list.size() == n) {
            answer = Math.max(answer, getCount());
            return;
        }

        for (int i = 0; i < n; i ++) {
            if (!list.contains(i)) { 
                list.add(i);
                calc();
                list.remove(list.size() - 1);
            }
        }
    }

    private static int getCount() {
        int count = 0;
        int dist = 0;
        for (int l: list) {
            Section section = sections.get(l);
            if (dist < section.s) {
                count++;
                dist = section.e;
            }
        }
        return count;
    }
}