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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode result = dummyHead;

        int l1Len = findListNodeLength(l1);
        int l2Len = findListNodeLength(l2);
        if (l1Len > l2Len) {
            l2 = adjustLength(l2, l1Len - l2Len);
        }
        if (l1Len < l2Len) {
            l1 = adjustLength(l1, l2Len - l1Len);
        }
        ListNode reverseLN1 = reverseListNode(l1);
        ListNode reverseLN2 = reverseListNode(l2);

        int carrier = 0;
        while (reverseLN1 != null || reverseLN2 != null || carrier != 0) {
            int val1 = (reverseLN1 != null) ? reverseLN1.val : 0;
            int val2 = (reverseLN2 != null) ? reverseLN2.val : 0;

            int sum = carrier + val1 + val2;
            carrier = sum / 10;

            // Corrected: Always attach to .next and move the result pointer
            result.next = new ListNode(sum % 10);
            result = result.next;

            if (reverseLN1 != null) reverseLN1 = reverseLN1.next;
            if (reverseLN2 != null) reverseLN2 = reverseLN2.next;
        }

        return reverseListNode(dummyHead.next);
    }

    private ListNode adjustLength(ListNode head, int diff) {
        ListNode currentHead = head;

        for (int i = 0; i < diff; i++) {
            ListNode newNode = new ListNode(0);
            newNode.next = currentHead;
            currentHead = newNode;
        }
        return currentHead;
    }


    private ListNode reverseListNode(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    private int findListNodeLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length = length + 1;
            head = head.next;
        }
        return length;
    }
}