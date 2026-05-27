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
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        List<Integer> integerList = new ArrayList<>();
        while (head != null) {
           
            if(!integerList.contains(head.val)) {
                System.out.println("value : " + head.val);
                integerList.add(head.val);
            } else {
                System.out.println("value : " + head.val);
                return true;
            }
             head = head.next;
        }
        return false;
    }
}
