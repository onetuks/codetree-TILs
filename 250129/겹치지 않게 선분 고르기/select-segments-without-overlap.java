import java.util.*;
import java.io.*;

class Section {
    int s;
    int e;

    Section(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public String toString() {
        return "{" + this.s + " " + this.e + "}";
    }
}

public class Main {

    private static int n;
    private static List<Section> sections = new ArrayList<>();
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i ++) {
            Section section = new Section(sc.nextInt(), sc.nextInt());
            sections.add(section);
        }

        sections.sort((a, b) -> a.s - b.s);

        int dist = 0;
        for (Section section: sections) {
            // System.out.println(section);
            if (dist < section.s) {
                answer++;
                dist = section.e;
            }
        }

        System.out.println(answer);
    }
}