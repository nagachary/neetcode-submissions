class Solution {
    public String simplifyPath(String path) {
        // Keep your splitting logic
        String[] tokens = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            token = token.trim();
            if (token.isEmpty() || token.equals(".")) {
                continue;
            }
            
            if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(token);
            }
        }
        
        Stack<String> tokenStack = new Stack<>();
        while (!stack.isEmpty()) {
            tokenStack.push(stack.pop());
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        while (!tokenStack.isEmpty()) {
            stringBuilder.append("/");
            stringBuilder.append(tokenStack.pop());
        }
        
        return stringBuilder.isEmpty() ? "/" : stringBuilder.toString();
    }
}