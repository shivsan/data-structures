import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
    N slots, K colors, 1 color can be adjacent to itself.
    How many permutations of colors can you put in N slots adhering to the contstraint.
 */
public class ButteryProblemTest {

    @Test
    public void noOfWays() {
        assertEquals(new ButteryProblem().getNoOfWays("", 3, 2, 1), 5);
        assertEquals(new ButteryProblem().getNoOfWays("", 5, 4, 3), 469);
    }

    @Test
    public void noOfWaysDP() {
        int n = 5;
        int k = 4;
        assertEquals(new ButteryProblem().getNoOfWays("", n, k, 1), new ButteryProblem().getNoOfWaysDP(n, k));

        n = 3;
        k = 2;
        assertEquals(new ButteryProblem().getNoOfWays("", n, k, 1), new ButteryProblem().getNoOfWaysDP(n, k));
    }
}