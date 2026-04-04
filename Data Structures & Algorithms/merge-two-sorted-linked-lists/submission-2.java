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
        ListNode sorted = new ListNode();
        ListNode dummy = sorted;
        ListNode curr1 = list1;
        ListNode curr2 = list2;

        while (curr1 != null && curr2 != null){
            if( curr1.val <= curr2.val){
                sorted.next = curr1;
                curr1 = curr1.next;
            }else {
                sorted.next = curr2;
                curr2 = curr2.next;
            }
            sorted = sorted.next;

        }

        if (curr1 != null){
            sorted.next = curr1;
        }

        if (curr2 != null){
            sorted.next = curr2;
        }

        return dummy.next;
    }
}