class MyHashMap {

    private final List<int[]> data;

    public MyHashMap() {
        data = new ArrayList<>();
    }

    public void put(int key, int value) {
        for (int[] element : data) {
            if (element[0] == key) {
                element[1] = value;
                return;
            }
        }

        data.add(new int[]{key, value});
    }

    public int get(int key) {
        for (int[] element : data) {
            if (element[0] == key) {
                return element[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i)[0] == key) {
                data.remove(i);
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < data.size(); i++) {
            sb.append(data.get(i)[0]).append("=").append(data.get(i)[1]);
            if (i < data.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */