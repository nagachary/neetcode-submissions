class TimeMap {

    private static Map<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        if (timeMap.isEmpty() || !timeMap.containsKey(key)) {
            TreeMap<Integer, String> valueMap = new TreeMap<>();
            valueMap.put(timestamp, value);
            timeMap.put(key, valueMap);
        } else {
            timeMap.get(key).put(timestamp, value);
        }
    }

    public String get(String key, int timestamp) {

        if (!timeMap.isEmpty() && timeMap.containsKey(key)) {
            TreeMap<Integer, String> treeMap = timeMap.get(key);

            if (null == treeMap) {
                return "";
            }
            if (!treeMap.isEmpty()) {
                Map.Entry<Integer, String> floorEntry = treeMap.floorEntry(timestamp);
                return null == floorEntry ? "" : floorEntry.getValue();
            }
        }

        return "";
    }
    
}
