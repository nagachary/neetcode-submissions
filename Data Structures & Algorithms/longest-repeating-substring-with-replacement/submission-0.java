class Solution {
    public int characterReplacement(String s, int k) {
       var strLength = s.length();
        int[] charCount = new int[26];
        var windStartIdx = 0;
        var maxStrLengthWithRepetChar = 0;
        var maxRepeatedCharCount = 0;

        for (var windEndIdx = 0; windEndIdx < strLength; windEndIdx++) {
            var charIdxinCharArray = s.charAt(windEndIdx) - 'A';
            charCount[charIdxinCharArray] = charCount[charIdxinCharArray] + 1;
            var currentCharCount = charCount[s.charAt(windEndIdx) - 'A'];
            maxRepeatedCharCount = Math.max(maxRepeatedCharCount, currentCharCount);
            while (windEndIdx - windStartIdx + 1 - maxRepeatedCharCount > k) {
                charCount[s.charAt(windStartIdx) - 'A']--;
                windStartIdx++;
            }
            maxStrLengthWithRepetChar = Math.max(maxStrLengthWithRepetChar, windEndIdx - windStartIdx + 1);
        }

        return maxStrLengthWithRepetChar;
    }
}
