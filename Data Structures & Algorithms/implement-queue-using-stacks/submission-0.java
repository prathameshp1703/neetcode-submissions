class MyQueue {

    Stack<Integer> pushStack;
    Stack<Integer> popStack;
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }
    
    public void push(int x) {
        pushStack.push(x);
    }
    
    public int pop() {
        if(popStack.size() == 0){
            while(pushStack.size()>0){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }
    
    public int peek() {
        if(popStack.size() == 0){
            while(pushStack.size()>0){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }
    
    public boolean empty() {
        return (pushStack.isEmpty() && popStack.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */