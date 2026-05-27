/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        int headALength = getListNodeLength(headA);
        int headBLength = getListNodeLength(headB);

        // If headA is longer, move headA forward by the difference
        while (headALength > headBLength) {
            headA = headA.next;
            headALength--;
        }
        // If headB is longer, move headB forward by the difference
        while (headBLength > headALength) {
            headB = headB.next;
            headBLength--;
        }

        // 3. Now that they are at the same distance from the end,
        // move them together until they point to the SAME node
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int getListNodeLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}