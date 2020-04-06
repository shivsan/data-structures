import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(JUnit4.class)
public class DistributeToTwoArraysTest {
    @Test
    public void shouldSort() {
        int[] a = new int[]{100, 1, 1, 2, 99, 100};
        DistributeToTwoArrays.sort(IntStream.of(a).boxed().collect(Collectors.toList()));
    }
}
