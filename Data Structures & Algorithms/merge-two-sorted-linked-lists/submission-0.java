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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1 && null != list2) {
            return list2;
        }

        if (null != list1 && null == list2) {
            return list1;
        }

        if (null == list1 && null == list2) {
            return null;
        }

        List<Integer> arrayList = new ArrayList<>();
        while (list1 != null) {
            arrayList.add(list1.val);
            list1 = list1.next;
        }

        while (list2 != null) {
            arrayList.add(list2.val);
            list2 = list2.next;
        }

        Collections.sort(arrayList);

        ListNode newNode = new ListNode();
        ListNode temp = newNode;

        for (int ele : arrayList) {
            temp.next = new ListNode(ele);
            temp = temp.next;
        }

        return newNode.next;
    }
}