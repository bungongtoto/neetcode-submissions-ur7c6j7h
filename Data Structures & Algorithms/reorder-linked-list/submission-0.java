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
    // O(n) time and O(n) space
    // public void reorderList(ListNode head) {
    //     if (head == null) return;

    //     List<ListNode> nodes = new ArrayList<>();
    //     ListNode cur = head;

    //     //push all nodes to array
    //     while (cur != null){
    //         nodes.add(cur);
    //         cur = cur.next;
    //     }

    //     //move accross array swap positions
    //     int i = 0, j = nodes.size() - 1;

    //     while (i < j){
    //         nodes.get(i).next = nodes.get(j);
    //         i++;
    //         if (i >= j) break;

    //         nodes.get(j).next = nodes.get(i);
    //         j--;
    //     }

    //     nodes.get(i).next = null;
    // }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        //get the middle of LinkedList
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the second part of the LinkedList
        ListNode second = slow.next;
        ListNode prev = slow.next =  null;

        while (second != null){
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }


        // merge the reverse and first part of the list
        ListNode first = head;
        second = prev;
        while (second != null){
            ListNode tempF = first.next;
            ListNode tempS = second.next;

            first.next = second;
            second.next = tempF;

            first = tempF;
            second = tempS;
        }

    }
}
