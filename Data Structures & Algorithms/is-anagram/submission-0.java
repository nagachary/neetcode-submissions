class Solution {
    public boolean isAnagram(String s, String t) {

        List<Character> sList = new ArrayList<>();
        for (char sc : s.toCharArray()) {
            sList.add(sc);
        }
        Collections.sort(sList);

        List<Character> tList = new ArrayList<>();
        for (char tc : t.toCharArray()) {
            tList.add(tc);
        }
        Collections.sort(tList);

        return sList.equals(tList);

    }
}
