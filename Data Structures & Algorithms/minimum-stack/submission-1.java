class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> curr;
    public MinStack() {
        minStack = new Stack<>();
        curr = new Stack<>();
    }
    
    public void push(int val) {
        curr.push(val);
        if(minStack.size() == 0){
            minStack.push(val);
        }
        else if(minStack.size()>0 && minStack.peek()>=val){
            minStack.push(val);
        }
    }
    
    public void pop() {
        int val = curr.pop();
        if(val == minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return curr.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
