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
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        if (size < k) {
            return temp;
        }

        Stack<ListNode> stack = new Stack<>();
        temp = head;
        ListNode listNode = new ListNode(-1);
        ListNode newtemp = listNode;
        int noOfRec = size / k;
        for (int i = 1; i <= noOfRec; i++) {
            int count = 0;
            while (temp != null && count < k) {
                stack.push(new ListNode(temp.val));
                temp = temp.next;
                count++;
            }
            while (!stack.isEmpty()) {
                newtemp.next = new ListNode(stack.peek().val);
                stack.pop();
                newtemp = newtemp.next;
            }
        }
        int remaining = size - noOfRec * k;
        for (int i = 0; i < remaining; i++) {
            newtemp.next = new ListNode(temp.val);
            temp = temp.next;
            newtemp = newtemp.next;
        }
        return listNode.next;
    }
}
