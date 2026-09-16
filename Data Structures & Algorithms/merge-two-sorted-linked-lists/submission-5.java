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
        ListNode c1 = list1, c2 = list2;

        ListNode dummy = new ListNode();
        ListNode p = dummy;

        while (c1 != null && c2 != null){
            if (c1.val <= c2.val){
                p.next = c1;
                c1 = c1.next;
            }else {
                p.next = c2;
                c2 = c2.next;
            }

            p = p.next;
        }


        while (c1 != null){
            p.next = c1;
            c1 = c1.next;

            p = p.next;
        }

        while (c2 != null){
            p.next = c2;
            c2 = c2.next;

            p = p.next;
        }

        return dummy.next;
    }
}