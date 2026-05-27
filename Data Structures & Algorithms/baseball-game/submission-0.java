class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String operation : operations) {
            switch (operation) {
                case "+" -> stack.push(stack.get(stack.size() - 1) + stack.get(stack.size() - 2));
                case "D" -> stack.push(stack.peek() * 2);
                case "C" -> stack.pop();
                default -> stack.push(Integer.parseInt(operation));
            }
        }
        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}