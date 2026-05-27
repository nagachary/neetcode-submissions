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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pseudoHead = new ListNode(0);
        pseudoHead.next = head;
        ListNode prev = pseudoHead;

        int i = 1;
        while (i < left) {
            prev = prev.next;
            i++;
        }

        ListNode curr = prev.next;
        while (i < right) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
            i++;
        }
        return pseudoHead.next;
    }
}