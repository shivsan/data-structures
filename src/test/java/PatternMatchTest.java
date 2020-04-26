import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

@RunWith(JUnit4.class)
public class PatternMatchTest {
    @Test
    public void should() {
        assertFalse(PatternMatch.isPattern(3));
        assertTrue(PatternMatch.isPattern(2));
        assertFalse(PatternMatch.isPattern(4));
        assertTrue(PatternMatch.isPattern(5));
        assertTrue(PatternMatch.isPattern(10));
    }
}