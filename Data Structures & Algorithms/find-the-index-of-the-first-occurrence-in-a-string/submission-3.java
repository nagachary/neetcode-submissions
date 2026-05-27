class Solution {
     public int strStr(String haystack, String needle) {
        if (haystack.isEmpty() || needle.isEmpty() || haystack.length() < needle.length()) {
            return -1;
        }
        int firstIndex;
        int i = 0;
        String haystackCopy = haystack;

        while (i <= haystack.length() - needle.length()) {
            firstIndex = haystackCopy.indexOf(needle.charAt(0));

            if (firstIndex == -1) {
                return -1;
            }

            if (firstIndex + needle.length() <= haystackCopy.length()
                    && haystackCopy.substring(firstIndex, firstIndex + needle.length()).equals(needle)) {
                return i + firstIndex;
            }

            i = i + firstIndex + 1;
            haystackCopy = haystack.substring(i);
        }

        return -1;
    }
}