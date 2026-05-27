class FreqStack {

    Stack<Integer> stack;
    HashMap<Integer, Integer> map;

    public FreqStack() {
        stack = new Stack<>();
        map = new HashMap<>();
    }

    public void push(int val) {
        stack.push(val);
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    public int pop() {
        int max_freq = 0;
        for (int f : map.values()) {
            max_freq = Math.max(max_freq, f);
        }
        
        int ele = -1;
        int indexInStack = -1;

        for (int i = stack.size() - 1; i >= 0; i--) {
            int currentVal = stack.get(i);
            if (map.get(currentVal) == max_freq) {
                ele = currentVal;
                indexInStack = i; // This is the element closest to the top
                break;
            }
        }
        
        map.put(ele, map.get(ele) - 1);
        return stack.remove(indexInStack);
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */