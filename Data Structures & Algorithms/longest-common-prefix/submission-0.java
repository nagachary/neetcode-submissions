class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (null == strs) {
            return null;
        }

        if (strs.length == 1) {
            return strs[0];
        }
        List<String> stringList = getStrings(strs);

        Map<String, Integer> tokenMap = new HashMap<>();
        for (String shortString : stringList) {

            int substr_len = shortString.length();
            while (substr_len > 0) {
                int count = 0;
                String sub_str = shortString.substring(0, substr_len);
                for (String string : strs) {
                    if (string.contains(sub_str)) {
                        count++;
                    }
                }
                tokenMap.put(sub_str, count);
                substr_len--;
            }
        }
        return findLongestCommonString(tokenMap, strs);
    }

    private String findLongestCommonString(Map<String, Integer> tokenMap, String[] strings) {
        int arrayLength = strings.length;
        List<String> commonPrefixs = new ArrayList<>();
        for (Map.Entry<String, Integer> token : tokenMap.entrySet()) {
            if (arrayLength == token.getValue()) {
                commonPrefixs.add(token.getKey());
            }
        }

        int max_length = Integer.MIN_VALUE;
        for (String commonPrefix : commonPrefixs) {
            max_length = Math.max(max_length, commonPrefix.length());
        }

        for (String commonPrefix : commonPrefixs) {
            if (max_length == commonPrefix.length()) {
                return commonPrefix;
            }
        }
        return "";
    }

    //Find the shortest strings
    private static List<String> getStrings(String[] strs) {
        Map<String, Integer> stringMap = new HashMap<>();
        List<String> stringList = new ArrayList<>();
        int min_length = Integer.MAX_VALUE;

        for (String str : strs) {
            min_length = Math.min(min_length, str.length());
            stringMap.put(str, str.length());
        }

        for (Map.Entry<String, Integer> mapEntry : stringMap.entrySet()) {
            if (mapEntry.getValue() == min_length) {
                stringList.add(mapEntry.getKey());
            }
        }
        return stringList;
    }
}