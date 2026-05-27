class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesisList = new ArrayList<>();
        backTrack(parenthesisList, new StringBuffer(), 0, n);
        return parenthesisList;
    }

    private void backTrack(List<String> parenthesisList, StringBuffer sb, int closeParanCount, int totalOpenParanCount) {
        if (closeParanCount == 0 && totalOpenParanCount == 0) {
            parenthesisList.add(sb.toString());
            return;
        }

        if (totalOpenParanCount > 0) {
            sb.append("(");
            backTrack(parenthesisList, sb, closeParanCount + 1, totalOpenParanCount - 1);
            sb.setLength(sb.length() - 1);
        }
        if (closeParanCount > 0) {
            sb.append(")");
            backTrack(parenthesisList, sb, closeParanCount - 1, totalOpenParanCount);
            sb.setLength(sb.length() - 1);
        }
    }
}
