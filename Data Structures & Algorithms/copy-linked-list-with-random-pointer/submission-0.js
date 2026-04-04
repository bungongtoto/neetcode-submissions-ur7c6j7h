// class Node {
//   constructor(val, next = null, random = null) {
//       this.val = val;
//       this.next = next;
//       this.random = random;
//   }
// }

class Solution {
    /**
     * @param {Node} head
     * @return {Node}
     */
    copyRandomList(head) {
        const mapOldNew = new Map();
        mapOldNew.set(null, null);
        let curr = head;

        while (curr){
            if (!mapOldNew.has(curr)){
                mapOldNew.set(curr, new Node(curr.val));
            }

            if (!mapOldNew.has(curr.next)){
                mapOldNew.set(curr.next, new Node(curr.next.val));
            }

            mapOldNew.get(curr).next = mapOldNew.get(curr.next);

            if (!mapOldNew.has(curr.random)){
                 mapOldNew.set(curr.random, new Node(curr.random.val));
            }
            mapOldNew.get(curr).random = mapOldNew.get(curr.random);

            curr = curr.next;
        }

        return mapOldNew.get(head);
    }
}
