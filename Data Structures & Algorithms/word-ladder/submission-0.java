class Solution {
    Set<String> dictionary;
    Queue<String> queue = new LinkedList<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        dictionary = new HashSet<>(wordList);
        queue.add(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String first = queue.poll();
                if (first.equals(endWord)) {
                    return count;
                }
                transformOtherWordsInTheList(first);
            }
            count++;
        }
        return 0;
    }

    private void transformOtherWordsInTheList(String word) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char currentChar = charArray[i];
            for (char character = 'a'; character <= 'z'; character++) {
                charArray[i] = character;
                String newString = new String(charArray);
                if (dictionary.contains(newString)) {
                    dictionary.remove(newString);
                    queue.add(newString);
                }
            }
            charArray[i] = currentChar;
        }
    }
}
