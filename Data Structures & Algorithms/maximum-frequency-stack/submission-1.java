class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Deque<Integer>> lookup;
    int maxFreq;
    public FreqStack() {
        lookup = new HashMap<>();
        freq = new HashMap<>();
        maxFreq = 0;
    }
    
    private void addToLookup(int freq, int val, Map<Integer, Deque<Integer>> lookup){
        if(lookup.containsKey(freq)){
            lookup.get(freq).add(val);
        }
        else{
            Deque<Integer> temp = new ArrayDeque<>();
            temp.add(val);
            lookup.put(freq, temp);
        }
    }

    private int removeFromLookup(Map<Integer, Deque<Integer>> lookup){
        Deque<Integer> maxFreqQueue = lookup.get(maxFreq);
        int ans = maxFreqQueue.peekLast();
        maxFreqQueue.removeLast();
        freq.put(ans, maxFreq-1);
        if(maxFreqQueue.size() == 0){
            lookup.remove(maxFreq);
            maxFreq--;
        }
        else{
            lookup.put(maxFreq, maxFreqQueue);
        }
        return ans;
    }

    public void push(int val) {
        if(freq.containsKey(val)){
            int currFreq = freq.get(val);
            currFreq++;
            maxFreq = Math.max(maxFreq, currFreq);
            addToLookup(currFreq, val, lookup);
            freq.put(val, currFreq);
        }
        else{
            freq.put(val, 1);
            maxFreq = Math.max(maxFreq, 1);
            addToLookup(1, val, lookup);
        }
        // System.out.println("maxFreq " + maxFreq);
    }
    
    public int pop() {
        return removeFromLookup(lookup);
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */