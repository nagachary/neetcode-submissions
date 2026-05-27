class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        if (sArray.length != tArray.length) {
            return false;
        }

        Map<Character, Integer> sArrayMap = new HashMap<>(26);
        for (int i = 0; i < sArray.length; i++) {
            sArrayMap.put(sArray[i], sArrayMap.getOrDefault(sArray[i], 0) + 1);
        }

        Map<Character, Integer> tArrayMap = new HashMap<>(26);
        for (int i = 0; i < tArray.length; i++) {
            tArrayMap.put(tArray[i], tArrayMap.getOrDefault(tArray[i], 0) + 1);
        }
        if (sArrayMap.equals(tArrayMap)) {
            return true;
        }

        return false;
    }
}
