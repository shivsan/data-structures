import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumOfUniqueElementsInArrayTest {

    @Test
    public void getSumOfUniqueElements() {
        assertEquals(SumOfUniqueElementsInArray.sum(new int[]{2, 2, 1, 4, 5, 6, 5, 4, 6}), 18);
        assertEquals(SumOfUniqueElementsInArray.sum(new int[]{}), 0);
    }
}