class LFUCache {

     class Node {
        int key, val, freq;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    class DoubleLinkedList {
        Node head, tail;
        int size;
        DoubleLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addNode(Node node) {
            Node nextNode = head.next;
            node.next = nextNode;
            node.prev = head;
            head.next = node;
            nextNode.prev = node;
            size++;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeTail() {
            if (size > 0) {
                Node node = tail.prev;
                removeNode(node);
                return node;
            }
            return null;
        }
    }

    private int capacity, minFreq, curSize;
    private Map<Integer, Node> cache;
    private Map<Integer, DoubleLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        updateFreq(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            updateFreq(node);
        } else {
            if (curSize == capacity) {
                DoubleLinkedList minList = freqMap.get(minFreq);
                Node toDelete = minList.removeTail();
                cache.remove(toDelete.key);
                curSize--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            minFreq = 1;
            DoubleLinkedList newList = freqMap.getOrDefault(1, new DoubleLinkedList());
            newList.addNode(newNode);
            freqMap.put(1, newList);
            curSize++;
        }
    }

    private void updateFreq(Node node) {
        int oldFreq = node.freq;
        DoubleLinkedList oldList = freqMap.get(oldFreq);
        oldList.removeNode(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;
        DoubleLinkedList newList = freqMap.getOrDefault(node.freq, new DoubleLinkedList());
        newList.addNode(node);
        freqMap.put(node.freq, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */