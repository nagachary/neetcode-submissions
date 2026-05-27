class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> sortedStrList = new ArrayList<>();
        List<List<String>> groupAnagrams = new ArrayList<>();

        for (String str : strs) {
            String sortString = sortString(str);
            if (!sortedStrList.contains(sortString)) {
                sortedStrList.add(sortString);
            }
        }

        for (String s : sortedStrList) {
            List<String> groupAnagram = new ArrayList<>();
            for (String str : strs) {
                if (isAnagram(s, str)) {
                    groupAnagram.add(str);
                }

                if (!groupAnagrams.contains(groupAnagram)) {
                    groupAnagrams.add(groupAnagram);
                }
            }
        }
        return groupAnagrams;
    }

    private String sortString(String str) {
        StringBuilder SB = new StringBuilder();
        List<Character> sList = sortList(str);
        for (Character c : sList) {
            SB.append(c);
        }
        return SB.toString();
    }

    private List<Character> sortList(String s) {
        List<Character> sList = new ArrayList<>();
        for (char sc : s.toCharArray()) {
            sList.add(sc);
        }
        Collections.sort(sList);
        return sList;
    }

    public boolean isAnagram(String s, String t) {
        return sortList(s).equals(sortList(t));
    }
}
