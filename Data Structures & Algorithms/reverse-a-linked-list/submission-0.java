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
       // Initialize three pointers: curr, prev and next
        ListNode previousNode = null;
        ListNode currentNode = head;
        ListNode nextNode;

        // Traverse all the nodes of Linked List
        while (currentNode != null) {
            // Store next node of the current node to nextNode
            nextNode = currentNode.next;
            // Reverse current node's next pointer
            currentNode.next = previousNode;
            // Move currentNode and nextNode pointers one position ahead
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode; 
    }
}
