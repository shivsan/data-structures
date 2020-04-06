import java.util.ArrayList;
import java.util.List;

public class Merge2Arrays {
    public static List<Integer> mergeArrays(List<Integer> a, List<Integer> b) {
        List<Integer> c = new ArrayList<>();
        int ai = 0, bi = 0;

        while (ai < a.size() && bi < b.size()) {
            if (a.get(ai) <= b.get(bi)) {
                c.add(a.get(ai));
                ai++;
            } else {
                c.add(b.get(bi));
                bi++;
            }
        }

        if (ai < a.size())
            c.addAll(a.subList(ai, a.size()));

        if (bi < b.size())
            c.addAll(b.subList(bi, b.size()));

        return c;
    }
}
