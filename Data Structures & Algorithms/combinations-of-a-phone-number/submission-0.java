class Solution {
    Map<String, String> keyPadNumbers = new HashMap<>();
    List<String> resultList = new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        keyPadNumbers.put("2", "abc");
        keyPadNumbers.put("3", "def");
        keyPadNumbers.put("4", "ghi");
        keyPadNumbers.put("5", "jkl");
        keyPadNumbers.put("6", "mno");
        keyPadNumbers.put("7", "pqrs");
        keyPadNumbers.put("8", "tuv");
        keyPadNumbers.put("9", "wxyz");

        if (digits == null || digits.isEmpty()) {
            return resultList;
        }
        backTrack(digits, "", 0);
        return resultList;
    }

    private void backTrack(String digits, String resultString, int index) {
        if (index == digits.length()) {
            resultList.add(resultString);
            return;
        }

        String letters = keyPadNumbers.get(String.valueOf(digits.charAt(index)));
        for (char letter : letters.toCharArray()) {
            backTrack(digits, resultString+letter, index+1);
        }
    }
}
