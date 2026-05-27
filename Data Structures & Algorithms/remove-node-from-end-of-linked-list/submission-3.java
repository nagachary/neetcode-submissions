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
    public ListNode removeNthFromEnd(ListNode head, int n) {
         if (head == null) {
            return head;
        }

        ListNode tempNode = head;
        int size = 0;
        while (tempNode != null) {
            size++;
            tempNode = tempNode.next;
        }

        if (n == size) {
            return head.next;
        }

        int elePosfrmHead = size - n;
        ListNode previousNode = head;

        for (int i = 1; i < elePosfrmHead; i++) {
            previousNode = previousNode.next;
        }
        previousNode.next = previousNode.next.next;

        return head;
    }
}
