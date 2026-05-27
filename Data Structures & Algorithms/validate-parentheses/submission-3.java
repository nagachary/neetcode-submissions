class Solution {
    public boolean isValid(String str) {
        int length = str.length();

        if (length % 2 != 0) {
            return false;
        }

        if (length == 0) {
            return false;
        }


        Stack<Character> bracketStack = new Stack<>();
        int count = 0;

        for (int i = 0; i < length; i++) {

            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                bracketStack.push(str.charAt(i));
            }

            if (bracketStack.isEmpty()) {
                return false;
            }

            if (str.charAt(i) == ']' && bracketStack.peek() == '[') {
                bracketStack.pop();
                count++;
            }

            if (str.charAt(i) == '}' && bracketStack.peek() == '{') {
                bracketStack.pop();
                count++;
            }

            if (str.charAt(i) == ')' && bracketStack.peek() == '(') {
                bracketStack.pop();
                count++;
            }
        }

        return bracketStack.isEmpty() && (count == length / 2);
    }
}
