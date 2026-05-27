class Solution {
    public boolean checkInclusion(String s1, String s2) {
     int s1Len = s1.length(), s2Len = s2.length();
        
        if (s1Len > s2Len || s2.isEmpty()) return false;

        if (s1.isEmpty()) return true;

        int[] charCountForS1 = new int[26];
        int[] charCountForS2 = new int[26];

        for (int i = 0; i < s1Len; i++) {
            charCountForS1[s1.charAt(i) - 'a']++;
            charCountForS2[s2.charAt(i) - 'a']++;
        }

        for (int i = s1Len; i < s2Len; i++) {

            if (Arrays.equals(charCountForS1, charCountForS2)) {
                return true;
            }

            charCountForS2[s2.charAt(i - s1Len) - 'a']--;
            charCountForS2[s2.charAt(i) - 'a']++;

        }

        if (Arrays.equals(charCountForS1, charCountForS2)) {
            return true;
        } else {
            return false;
        }   
    }
}
