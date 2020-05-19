import org.junit.Test;

import java.util.Arrays;

public class StockSpannerTest {

    @Test
    public void next() {
        int[] prices = new int[]{100, 80, 60, 70, 60, 75, 85};

        StockSpanner stockSpanner = new StockSpanner();

        Arrays.stream(prices).forEach(p -> System.out.println(stockSpanner.next(p)));
    }
}