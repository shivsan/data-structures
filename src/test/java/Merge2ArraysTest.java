import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(JUnit4.class)
public class Merge2ArraysTest {

    @Test
    public void shouldSort() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(5);
        b.add(5);

        List<Integer> sortedList = Merge2Arrays.mergeArrays(a, b);

        List<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(2);
        c.add(3);
        c.add(5);
        c.add(5);
        assertThat(sortedList, is(c));
    }

    @Test
    public void shouldSort1() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1);
        a.add(1);

        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(5);
        b.add(5);

        List<Integer> sortedList = Merge2Arrays.mergeArrays(a, b);

        List<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(1);
        c.add(1);
        c.add(2);
        c.add(5);
        c.add(5);
        assertThat(sortedList, is(c));
    }

    @Test
    public void should() {
        List<String> tools = new ArrayList<>();
        tools.add("facemill");
        tools.add("slotdrill");
        tools.add("ballendmill");
        tools.add("ballendmill");

        int k = 0;
        String q = "ballendmill";
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < tools.size(); i++) {
            indices.add(i);
        }

        final int min = indices.stream()
                .map(i -> Math.min(Math.abs(i - k), Math.abs((tools.size()) + i - k)))
                .min(Integer::compareTo)
                .orElse(-1);

        System.out.println(min);
    }
}