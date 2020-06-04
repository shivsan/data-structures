import org.junit.Test;

import static org.junit.Assert.*;

public class YoodelTest {

    @Test
    public void testYoodel() {
        new Yoodel().sortHasMap();
    }

    @Test
    public void printAllPermutations() {
        new Yoodel().printAllPermutations(new char[] {'a', 'b', 'c', 'd', 'e', 'f'});
    }
}

// Transactions across polyglot DBs
// Sort billion element array with parallelism
// JRS in spring REST