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
    public void reorderList(ListNode head) {
        
        if (head == null || head.next == null) {

            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode previousNode = null;
        ListNode currentNode = slow;

        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        ListNode first = head;
        ListNode second = previousNode;


        while (second.next != null) {
            ListNode tempNode = first.next;
            first.next = second;
            first = tempNode;

            tempNode = second.next;
            second.next = first;
            second = tempNode;
        }
    }
}
