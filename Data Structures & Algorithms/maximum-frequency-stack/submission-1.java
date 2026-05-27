class FreqStack {
    Map<Integer, Integer> frequency_map;
    Map<Integer, Stack<Integer>> frequency_stack_elements;
    int maxFreq;

    public FreqStack() {
        frequency_map = new HashMap<>();
        frequency_stack_elements = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int frequency = frequency_map.getOrDefault(val, 0) + 1;
        frequency_map.put(val, frequency);
        maxFreq = Math.max(frequency, maxFreq);
        frequency_stack_elements.computeIfAbsent(frequency, k -> new Stack<>()).push(val);
    }

    public int pop() {
        int val = frequency_stack_elements.get(maxFreq).pop();
        frequency_map.put(val, frequency_map.get(val) - 1);
        if (frequency_stack_elements.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */