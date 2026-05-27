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
    public ListNode reverseList(ListNode head) {
       if (head == null) {
            return head;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode listNode = head;

        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        listNode = head;
        while (listNode != null) {
            listNode.val = stack.pop();
            listNode = listNode.next;
        }

        return head;
    }
}
