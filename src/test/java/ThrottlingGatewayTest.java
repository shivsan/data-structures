import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

public class ThrottlingGatewayTest {
    private ThrottlingGateway throttlingGateway;

    @Before
    public void setUp() throws Exception {
        this.throttlingGateway = new ThrottlingGateway();
    }

    @Test
    public void test1() {
        final List<Integer> stream = Arrays.stream(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11}).mapToObj(i -> new Integer(i)).collect(Collectors.toList());
        final int result = throttlingGateway.droppedRequests(stream);
        assertEquals(7, result);
    }

    @Test
    public void test2() {
        final List<Integer> stream = Arrays.stream(new int[]{1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 16, 16, 17, 17, 17, 17, 17, 17, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20, 20, 20,}).mapToObj(i -> i).collect(Collectors.toList());
        final int result = throttlingGateway.droppedRequests(stream);
        assertEquals(129, result);
    }
}