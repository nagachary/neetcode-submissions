/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int length = listNodeLength(head);
        k = k % length;
        if (k == 0) return head;

        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        for (int i = 0; i < length; i++) {
            if (i >= length - k) {
                stack.push(temp.val);
            }
            temp = temp.next;
        }

        ListNode newHead = new ListNode(-1);
        ListNode current = newHead;
        while (!stack.isEmpty()) {
            ListNode listNode = new ListNode(stack.pop());
            current.next = listNode;
            current = current.next;
        }
        
        ListNode revNode = reverseListNode(newHead.next);
        ListNode tempRevNode = revNode;
        
        while (tempRevNode.next != null) {
            tempRevNode = tempRevNode.next;
        }
        tempRevNode.next = head;
        
        ListNode breaker = head;
        for (int i = 0; i < length - k - 1; i++) {
            breaker = breaker.next;
        }
        breaker.next = null;

        return revNode;
    }

    private int listNodeLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length = length + 1;
            head = head.next;
        }
        return length;
    }

    private ListNode reverseListNode(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}