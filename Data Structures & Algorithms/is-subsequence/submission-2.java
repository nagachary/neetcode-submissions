class Solution {
       public boolean isSubsequence(String s, String t) {

        StringBuilder sbr = new StringBuilder();
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                sbr.append(t.charAt(j));
                i++;
            }
            j++;
        }

        return s.equals(sbr.toString());
    }
}