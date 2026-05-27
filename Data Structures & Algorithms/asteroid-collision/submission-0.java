class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int currentAsteriod : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && currentAsteriod < 0) {
                int topElement = stack.peek();
                if (topElement < Math.abs(currentAsteriod)) {
                    stack.pop();
                    continue;
                } else if (topElement == Math.abs(currentAsteriod)) {
                    stack.pop();
                    currentAsteriod = 0;
                } else {
                    currentAsteriod = 0;
                }
                break;
            }

            if (currentAsteriod != 0) {
                stack.push(currentAsteriod);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}