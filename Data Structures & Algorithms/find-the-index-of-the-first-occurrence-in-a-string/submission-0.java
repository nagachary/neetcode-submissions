class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.isEmpty() || needle.isEmpty() || haystack.length() < needle.length()) {
            return -1;
        }

        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }

        return -1;
    }
}