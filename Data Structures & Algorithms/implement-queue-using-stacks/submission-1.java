class MyQueue {

   private Stack<Integer> initalStack;
    private Stack<Integer> finalStack;

    public MyQueue() {
        initalStack = new Stack<>();
        finalStack = new Stack<>();
    }

    public void push(int x) {
        initalStack.push(x);
    }

    public int pop() {
        shiftStacks();
        return finalStack.pop();
    }

    public int peek() {
        shiftStacks();
        return finalStack.peek();
    }

    public boolean empty() {
        return initalStack.isEmpty() && finalStack.isEmpty();
    }

    private void shiftStacks() {
        if (finalStack.isEmpty()) {
            while (!initalStack.isEmpty()) {
                finalStack.push(initalStack.pop());
            }
        }
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