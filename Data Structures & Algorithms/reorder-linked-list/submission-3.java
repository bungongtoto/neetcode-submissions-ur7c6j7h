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
    public void reorderList(ListNode head) {
        //use slow and fast to get to mid of the list
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //split the list at the slow point
        ListNode curr = slow.next;
        slow.next = null;
        //reverse the second half of the List
        ListNode prev = null;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // merge the two halfs of the list
        curr = head;
        ListNode second = prev;

        while (curr != null && second != null){
            ListNode temp1 = curr.next;
            ListNode temp2 = second.next;

            curr.next = second;
            second.next = temp1;

            curr = temp1;
            second = temp2;
        }

    }
}
