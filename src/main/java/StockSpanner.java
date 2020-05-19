import java.util.Stack;

class StockSpanner {
    private Stack<StockSpan> stockSpanStack;

    public StockSpanner() {
        stockSpanStack = new Stack<StockSpan>();
    }

    public int next(int price) {
        StockSpan stockSpan = new StockSpan();
        stockSpan.stockPrice = price;
        stockSpan.span = 1;

        while (!stockSpanStack.isEmpty() && stockSpanStack.peek().stockPrice <= stockSpan.stockPrice) {
            final StockSpan poppedStockSpan = stockSpanStack.pop();
            stockSpan.span += poppedStockSpan.span;
        }

        stockSpanStack.push(stockSpan);
        return stockSpan.span;
    }

    class StockSpan {
        public int stockPrice;
        public int span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */