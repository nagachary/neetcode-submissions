class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> wordFreq = new LinkedHashMap<>();
        if (arr.length == 0) {
            return "";
        }

        for (String ele : arr) {
            wordFreq.put(ele, wordFreq.getOrDefault(ele, 0) + 1);
        }

        int counter = 0;
        for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
            if (entry.getValue() == 1) {
                counter ++;
                if(counter == k) {
                    return entry.getKey();
                }
            }
        }
        return "";
    }
}