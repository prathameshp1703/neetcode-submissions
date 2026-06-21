class MyStack {
    Queue<Integer> curr;
    public MyStack() {
        curr = new LinkedList<>();
    }
    
    public void push(int x) {
        curr.add(x);
    }
    
    public int pop() {
        int size = curr.size();
        for(int i=0; i<size-1; i++){
            int front = curr.poll();
            curr.add(front);
        }
        int poppedElement = curr.poll();
        return poppedElement;
    }
    
    public int top() {
        int topElement = -1;
        int size = curr.size();
        for(int i=0; i<size; i++){
            topElement = curr.poll();
            curr.add(topElement);
        }

        return topElement;
    }
    
    public boolean empty() {
        return (curr.size() == 0);
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */