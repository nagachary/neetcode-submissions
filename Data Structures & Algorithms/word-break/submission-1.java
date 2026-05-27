class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        // stringCharArray[i] = true if substring s[0..i-1] can be segmented
        boolean[] stringCharArray = new boolean[length + 1];
        stringCharArray[0] = true;

        for (int i = 1; i <= length; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && stringCharArray[i - len]) {
                    if (s.substring(i - len, i).equals(word)) {
                        stringCharArray[i] = true;
                        break;
                    }
                }
            }
        }
        return stringCharArray[length];
    }
}
