import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(JUnit4.class)
public class Merge2ArraysTest {
//
//    @Test
//    public void shouldSort() {
//        List<Integer> a = new ArrayList<>();
//        a.add(1);
//        a.add(2);
//        a.add(3);
//
//        List<Integer> b = new ArrayList<>();
//        b.add(2);
//        b.add(5);
//        b.add(5);
//
//        List<Integer> sortedList = Merge2Arrays.mergeArrays(a, b);
//
//        List<Integer> c = new ArrayList<>();
//        c.add(1);
//        c.add(2);
//        c.add(2);
//        c.add(3);
//        c.add(5);
//        c.add(5);
//        assertThat(sortedList, is(c));
//    }
//
//    @Test
//    public void shouldSort1() {
//        List<Integer> a = new ArrayList<>();
//        a.add(1);
//        a.add(1);
//        a.add(1);
//
//        List<Integer> b = new ArrayList<>();
//        b.add(2);
//        b.add(5);
//        b.add(5);
//
//        List<Integer> sortedList = Merge2Arrays.mergeArrays(a, b);
//
//        List<Integer> c = new ArrayList<>();
//        c.add(1);
//        c.add(1);
//        c.add(1);
//        c.add(2);
//        c.add(5);
//        c.add(5);
//        assertThat(sortedList, is(c));
//    }

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

    @Test
    public void doStuff() {
        Character[] chs = new Character[]{'a','b', 'a', 'b', 'c', 'b', 'a', 'c', 'a', 'd', 'e', 'f', 'e', 'g', 'd', 'e', 'h', 'i', 'j', 'h', 'k', 'l', 'i', 'j'};

        final List<Integer> integers = Merge2Arrays.partitionLabels(Arrays.stream(chs).collect(Collectors.toList()));

        System.out.println(integers);
    }

    @Test
    public void doMatch() {
        final List<String> toyList = Arrays.stream(new String[]{"elmo"}).collect(Collectors.toList());

        System.out.println("Hello");
        System.out.println(new Merge2Arrays().getToyInQuote(      "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!", toyList));
    }

    @Test
    public void doToys() {
        final List<String> toyList = Arrays.stream(new String[]{"elmo", "elsa", "legos", "drone", "tablet", "warcraft"}).collect(Collectors.toList());
        final List<String> quotes = Arrays.stream(new String[]{
                "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year",
                "Elsa and Elmo are the toys I'll be buying for my kids",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season"
        }).collect(Collectors.toList());

        System.out.println("Hello");
        final List<String> strings = new Merge2Arrays().popularNToys(3, 2, toyList, 0, quotes);
        System.out.println(strings);
    }

    @Test
    public void check() {
        final String tat = new Merge2Arrays().ruleForConsonant("tat");
        System.out.println(tat);
    }
}