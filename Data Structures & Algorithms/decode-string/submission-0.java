class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        StringBuilder numBuffer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                numBuffer.append(ch);
            } else if (ch == '[') {
                countStack.push(Integer.parseInt(numBuffer.toString()));
                numBuffer.setLength(0);

                resStack.push(current);
                current = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder contentToRepeat = current;
                int repeatTimes = countStack.pop();

                current = resStack.pop();

                for (int j = 0; j < repeatTimes; j++) {
                    current.append(contentToRepeat);
                }

            } else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}