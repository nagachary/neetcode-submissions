class Solution {
    List<List<String>> result = new LinkedList<>();
    public List<List<String>> partition(String s) {
        List<String> subList = new ArrayList<>();
        backTrack(subList, s, 0);
        return result;
    }
    
    private void backTrack(List<String> subList, String s, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(subList));
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                subList.add(s.substring(index, i + 1));
                backTrack(subList, s, i + 1);
                subList.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int startIdx, int endIdx) {
        while (startIdx < endIdx) {
            if (s.charAt(startIdx++) != s.charAt(endIdx--)) {
                return false;
            }
        }
        return true;
    }
}
