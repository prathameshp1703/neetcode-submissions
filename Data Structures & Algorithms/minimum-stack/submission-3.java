class MinStack {
    Stack<Long> minStack;
    long minElement;
    public MinStack() {
        minStack = new Stack<>();
        minElement = -1;
    }
    
    public void push(int val) {
        long tempVal = (long)val;
        if(minStack.size() == 0){
            minStack.push(tempVal);
            minElement = tempVal;
            return;
        }
        if(tempVal < minElement){
            minStack.push(2*tempVal-minElement);
            minElement = tempVal;
        }
        else{
            minStack.push(tempVal);
        }
    }
    
    public void pop() {
        long curr = minStack.pop();
        if(curr < minElement){
            minElement = 2*minElement - curr;
        }
    }
    
    public int top() {
        long curr = minStack.peek();
        if(curr < minElement){
            curr = minElement;
        }
        return (int)curr;
    }
    
    public int getMin() {
        return (int) minElement;
    }
}
