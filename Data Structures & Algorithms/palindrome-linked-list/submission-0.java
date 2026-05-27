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
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;

        ListNode dummy = new ListNode(0);
        ListNode copyCurr = dummy;
        ListNode curr = head;

        while (curr != null) {
            copyCurr.next = new ListNode(curr.val);
            copyCurr = copyCurr.next;
            curr = curr.next;
        }
        ListNode copyHead = dummy.next;

        ListNode reversedHead = reverseListNode(copyHead);
        ListNode p1 = head;
        ListNode p2 = reversedHead;

        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    private ListNode reverseListNode(ListNode head) {
        ListNode prevListNode = null;
        ListNode currListNode = head;
        while (currListNode != null) {
            ListNode nextTempListNode = currListNode.next;
            currListNode.next = prevListNode;
            prevListNode = currListNode;
            currListNode = nextTempListNode;
        }

        return prevListNode;
    }
}