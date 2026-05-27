class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            charMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (j >= words[i + 1].length()) {
                    return false;
                }
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    int firstWordChar = charMap.get(words[i].charAt(j));
                    int nextWordChar = charMap.get(words[i + 1].charAt(j));

                    if (firstWordChar > nextWordChar) {
                        return false;
                    } else {
                        break;
                    }
                }
            }

        }
        return true;
    }
}