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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (ListNode listNode : lists) {
            while (listNode != null) {
                queue.add(listNode.val);
                listNode = listNode.next;
            }
        }
        
        ListNode newListNode = new ListNode();
        ListNode temp = newListNode;

        while (!queue.isEmpty()){
            temp.next = new ListNode(queue.peek());
            queue.poll();
            temp = temp.next;
        }
        return newListNode.next;
    }
}
