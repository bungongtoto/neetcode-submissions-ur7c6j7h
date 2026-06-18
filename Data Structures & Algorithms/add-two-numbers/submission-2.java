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
        ListNode dommy = new ListNode();
        ListNode cur = dommy;
        int remender = 0;

        while (l1 != null || l2 != null || remender != 0){
            int val1 = (l1 != null) ?  l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + remender;
            remender = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
            cur = cur.next;
        }

        return dommy.next;
    }
}
