class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0)+1);
        }

        int max = Integer.MIN_VALUE;
        ArrayList<Integer> values = new ArrayList<>(freq.values());
        for (int i = 0; i < values.size(); i++) {
            for (int j = 0; j < values.size(); j++) {
                
                int val1 = values.get(i);
                int val2 = values.get(j);
                if (val1 % 2 != 0 && val2 % 2 == 0) {
                    max = Math.max(max, val1 - val2);
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}