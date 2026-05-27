class MinStack {

    Stack<Integer> mainStack = null;
    Stack<Integer> minStack = null;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public int pop() {
        if (mainStack.isEmpty()) {
            return -1;
        }
        int popEle = mainStack.pop();
        minStack.pop();
        return popEle;
    }

    public int top() {
        if (mainStack.isEmpty()) {
            return -1;
        }
        return mainStack.peek();
    }


    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }
}
