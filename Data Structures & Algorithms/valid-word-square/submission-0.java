class Solution {
    public boolean validWordSquare(List<String> words) {
        List<String> newWords = new ArrayList<>();
        StringBuilder newString = new StringBuilder();
        int j = 0;

        for (int i = 0; i < words.size(); i++) {
            if (j < words.get(i).length()) {
                newString.append(words.get(i).charAt(j));
            }

            if (i == words.size() - 1) { 
                newWords.add(newString.toString());
                newString = new StringBuilder();
                j++;
                i = -1;
                if (j == words.size()) {
                    break;
                }
            }
        }

        return newWords.equals(words);
    }
}
