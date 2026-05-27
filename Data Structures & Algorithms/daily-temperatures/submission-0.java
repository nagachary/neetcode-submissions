class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       Stack<Integer> warmerDayStack = new Stack<>();
        int[] nextTempDays = new int[temperatures.length];


        for (int i = temperatures.length - 1; i > -1; i--) {

            while (!warmerDayStack.isEmpty()
                    && temperatures[i] >= temperatures[warmerDayStack.peek()]) {
                warmerDayStack.pop();
            }

            if (!warmerDayStack.isEmpty()) {
                nextTempDays[i] = warmerDayStack.peek() - i;
            }

            warmerDayStack.push(i);
        }

        return nextTempDays;
    }
}
