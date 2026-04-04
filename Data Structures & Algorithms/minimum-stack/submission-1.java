class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        //add val to stack
        stack.push(val);
        //add to min stack
        if (minStack.isEmpty()){
            minStack.push(val);
        }else {
            int min = minStack.peek();
            if (min > val){
                minStack.push(val);
            }else {
                minStack.push(min);
            }
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()){
            stack.pop();
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
