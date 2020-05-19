import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class SplitWordsTest {

    @Test
    public void shouldSplitWordTest1() {
        final String sentence = "catsanddogs";
        final String[] dictionary = {"cats", "cat", "dogs", "sand", "and"};

        System.out.println(new SplitWords().split(Arrays.stream(dictionary).collect(Collectors.toList()), sentence));
    }

    @Test
    public void shouldSplitWordTest2() {
        final String sentence = "pineapplepenapple";
        final String[] dictionary = {"apple", "pen", "applepen", "pine", "pineapple"};

        System.out.println(new SplitWords().split(Arrays.stream(dictionary).collect(Collectors.toList()), sentence));
    }

    @Test
    public void shouldGetAllSmallerWords() {
        final String sentence = "catsanddogs";
        final String[] dictionary = {"cats", "cat", "dogs", "sand"};

        final List<String> smallerWordsFromSentence = new SplitWords().getSmallerFirstWordsFromSentence(Arrays.stream(dictionary).collect(Collectors.toList()), sentence);

        final List<String> expectedList = Arrays.stream(new String[]{"cat", "cats"}).collect(Collectors.toList());
        assertEquals(expectedList.get(0), smallerWordsFromSentence.get(0));
        assertEquals(expectedList.get(1), smallerWordsFromSentence.get(1));
    }
}