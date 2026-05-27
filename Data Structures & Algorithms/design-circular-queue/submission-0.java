class MyCircularQueue {

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head, tail;
    private int count;
    private int capacity;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.count = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        // Connect tail back to head to make it "circular"
        tail.next = head;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head; // Maintain the circular connection
        }

        count--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : head.value;
    }

    public int Rear() {
        return isEmpty() ? -1 : tail.value;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */