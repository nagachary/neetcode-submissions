class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        int length1 = word1.length();
        int length2 = word2.length();
        if (length1 == length2) {
            for (int i = 0; i < length1; i++) {
                stringBuilder.append(word1.charAt(i)).append(word2.charAt(i));
            }
        } else if (length1 > length2) {
            for (int i = 0; i < length2; i++) {
                stringBuilder.append(word1.charAt(i)).append(word2.charAt(i));
            }
            for (int i = length2; i < length1; i++) {
                stringBuilder.append(word1.charAt(i));
            }
        } else {
            for (int i = 0; i < length1; i++) {
                stringBuilder.append(word1.charAt(i)).append(word2.charAt(i));
            }
            for (int i = length1; i < length2; i++) {
                stringBuilder.append(word2.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}