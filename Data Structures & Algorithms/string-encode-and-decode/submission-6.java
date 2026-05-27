class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str.length()).append(',');
        }

        res.append('#');
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> strList = new ArrayList<>();
        if (str == "") {
            return strList;
        }
        String[] numericsArr = str.substring(0, str.indexOf('#')).split(",");
        String originalString = str.substring(str.indexOf('#') + 1);
        int startIdx = 0;
        for (int i = 0; i < numericsArr.length; i++) {
            int tokenLength = Integer.parseInt(numericsArr[i]);
            int endIdx = startIdx+tokenLength;
            strList.add(originalString.substring(startIdx, endIdx));
            startIdx = endIdx;
        }
        return strList;
    }
}
