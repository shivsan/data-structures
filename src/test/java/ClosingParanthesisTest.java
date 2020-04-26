import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ClosingParanthesisTest {

    private ClosingParanthesis closingParanthesis;

    @Before
    public void setUp() {
        closingParanthesis = new ClosingParanthesis();
    }

    @Test
    public void shouldReturnValid() {
        assertTrue(closingParanthesis.isValid(""));
        assertTrue(closingParanthesis.isValid("()"));
        assertTrue(closingParanthesis.isValid("()[]{}"));
        assertTrue(closingParanthesis.isValid("([][]{[()]})"));
    }

    @Test
    public void shouldReturnInvalid() {
        assertFalse(closingParanthesis.isValid("()("));
        assertFalse(closingParanthesis.isValid("(]"));
        assertFalse(closingParanthesis.isValid("]["));
    }
}