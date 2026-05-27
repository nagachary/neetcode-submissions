class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb1.append(s.charAt(i));
            }
        }
        String s1 = sb1.toString().toLowerCase();

        StringBuilder sb2 = new StringBuilder();
        for (int i = s1.length() - 1; i >= 0; i--) {
            sb2.append(s1.charAt(i));
        }
        String s2 = sb2.toString().toLowerCase();

        return s1.equals(s2);
    }
}
