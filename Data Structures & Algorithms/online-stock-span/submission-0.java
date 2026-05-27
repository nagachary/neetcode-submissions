class StockSpanner {

    List<Integer> stockList;

    public StockSpanner() {
        stockList = new ArrayList<>();
    }

    public int next(int price) {
        stockList.add(price);
        int count = 0;
        if (stockList.size() == 1) {
            return stockList.size();
        }
        for (int i = stockList.size() - 1; i >= 0; i--) {
            if (price >= stockList.get(i)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */