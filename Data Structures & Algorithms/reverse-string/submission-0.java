class Solution {
    public void reverseString(char[] s) {
             int count = s.length;
        for (int i = 0; i < count/2; i++) {
            char temp = s[i];
            s[i] = s[count - 1 - i];
            s[count - 1 - i] = temp;
        }
        
    }
}