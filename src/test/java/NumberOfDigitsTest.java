import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfDigitsTest {

    @Test
    public void getNumberOfDigits() {
        assertEquals(11, NumberOfDigits.getNumberOfDigits(10));
        assertEquals(9, NumberOfDigits.getNumberOfDigits(9));
        assertEquals(192, NumberOfDigits.getNumberOfDigits(100));
        assertEquals(2893, NumberOfDigits.getNumberOfDigits(1000));
    }
}