import org.junit.Test;

public class YoodelTest {

    @Test
    public void testYoodel() {
//        new Yoodel().sortHashMap();
    }

    @Test
    public void printAllPermutations() {
        new Yoodel().printAllPermutationsRecursively(new char[] {'a', 'b', 'c', 'd', 'e', 'f'});
    }

    @Test
    public void printAllPermutationsIteratively() {
        new Yoodel().printAllPermutationsIteratively(new char[] {'a', 'b', 'c', 'd', 'e', 'f'});
    }
}

// Transactions across polyglot DBs
// Sort billion element array with parallelism
// JRS in spring REST
