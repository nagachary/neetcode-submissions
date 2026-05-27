class StockSpanner {

    Stack<int[]> stockStack;
    public StockSpanner() {
        stockStack = new Stack();
    }

    public int next(int price) {
        int count = 1;
        while (!stockStack.isEmpty() && stockStack.peek()[0] <= price) {
            count = count + stockStack.pop()[1];
        }
        stockStack.push(new int[]{price, count});
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */