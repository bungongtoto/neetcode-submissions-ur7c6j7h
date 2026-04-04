/**
 * Definition for singly-linked list.
 * class ListNode {
 *     constructor(val = 0, next = null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    /**
     * @param {ListNode} l1
     * @param {ListNode} l2
     * @return {ListNode}
     */
    addTwoNumbers(l1, l2) {
        let hold = 0;
        const dummyNode = new ListNode();
        let copyNode = dummyNode;

        while (l1 !== null || l2 !== null){
            const sum = (l1?.val ?? 0) + (l2?.val ?? 0) + hold;
            const newNode = new ListNode();

            newNode.val = sum % 10;
            hold = Math.floor(sum / 10);

            copyNode.next = newNode;
            copyNode = newNode;

            l1 = l1?.next ?? null;
            l2 = l2?.next ?? null;

            if (l1 === null && l2 === null && hold !== 0){
                copyNode.next = new ListNode(hold);
            }
        }

        return dummyNode.next;
    }
}
