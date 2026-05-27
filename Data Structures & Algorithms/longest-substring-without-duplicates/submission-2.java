class Solution {
    public int lengthOfLongestSubstring(String s) {
               int maxLength = 0;
        int n = s.length();
        int leftIdx = 0;
        Set<Character> charSet = new HashSet<>();

        for (int endIdx = 0; endIdx < n; endIdx++) {
            while (charSet.contains(s.charAt(endIdx))){
                charSet.remove(s.charAt(leftIdx));
                leftIdx ++;
            }

            charSet.add(s.charAt(endIdx));
            maxLength = Math.max(maxLength, endIdx-leftIdx+1);
        }
        return maxLength;
    }
}
