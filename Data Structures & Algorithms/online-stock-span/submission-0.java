class StockSpanner {
    class Pair{
        int value;
        int index;

        Pair(int value, int index){
            this.value = value;
            this.index = index;
        }
    }

    Stack<Pair> stockSpan;
    int currIndex;
    public StockSpanner() {
        stockSpan = new Stack<>();
        currIndex = 0;
    }
    
    public int next(int price) {
        int ans = -1;
        currIndex++;
        while(stockSpan.size()>0 && stockSpan.peek().value <= price){
            stockSpan.pop();
        }
        if(stockSpan.size() == 0){
            ans = currIndex;
        }
        else{
            ans = currIndex-stockSpan.peek().index;
        }
        stockSpan.push(new Pair(price, currIndex));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */