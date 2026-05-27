class Solution {
    public boolean validPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int size = charArray.length;
        for (int i = 0; i < size / 2; i++) {
            int j = size - i - 1;
            if (charArray[i] == charArray[j]) {
                continue;
            } else {
                return isPalindrome(charArray, i + 1, j) || isPalindrome(charArray, i, j - 1);
            }
        }
        return true;
    }

    private boolean isPalindrome(char[] charArray, int i, int j) {
        while (i < j) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}