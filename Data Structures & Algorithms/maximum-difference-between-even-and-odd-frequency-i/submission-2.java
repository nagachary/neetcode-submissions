class Solution {
    public int maxDifference(String s) {
         Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0)+1);
        }
       int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;
        for (Integer val : freq.values()) {
            if(val % 2 == 0) {
                minEven = Math.min(minEven, val);
            } else {
                maxOdd = Math.max(maxOdd, val);
            }
        }
        return maxOdd - minEven;
    }
}