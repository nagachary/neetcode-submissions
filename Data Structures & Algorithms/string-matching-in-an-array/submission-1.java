class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int j = 0;
            while (j < words.length) {
                if (!words[i].equals(words[j]) && words[i].contains(words[j])) {
                    if (!strings.contains(words[j])) {
                        strings.add(words[j]);
                    }
                }
                j++;
            }
        }
        return strings;
    }
}