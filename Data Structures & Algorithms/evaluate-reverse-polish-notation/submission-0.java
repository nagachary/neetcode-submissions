class Solution {
    public static int evalRPN(String[] tokens) {
       Stack<Integer> stringStack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int x = stringStack.pop();
                int y = stringStack.pop();
                int result = x + y;
                stringStack.push(result);
            } else if ("-".equals(token)) {
                int x = stringStack.pop();
                int y = stringStack.pop();
                int result = y - x;
                stringStack.push(result);
            } else if ("*".equals(token)) {
                int x = stringStack.pop();
                int y = stringStack.pop();
                int result = y * x;
                stringStack.push(result);
            } else if ("/".equals(token)) {
                int x = stringStack.pop();
                int y = stringStack.pop();
                int result = y / x;
                stringStack.push(result);
            } else {
                stringStack.push(Integer.valueOf(token));
            }
        }
        return stringStack.peek();
    }
}
