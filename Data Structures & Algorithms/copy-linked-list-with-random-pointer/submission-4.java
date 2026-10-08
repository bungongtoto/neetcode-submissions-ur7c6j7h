/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);

        Node curr = head;

        while (curr != null){
            // copy node
            map.putIfAbsent(curr, new Node(0));
            map.get(curr).val = curr.val;
            // copy next 
            if (curr.next != null){
                map.putIfAbsent(curr.next, new Node(0));
            }
            map.get(curr).next = map.get(curr.next);
            // copy random
           if (curr.random != null){
             map.putIfAbsent(curr.random, new Node(0));
           }
            map.get(curr).random = map.get(curr.random);

            curr = curr.next;
        }

        return map.get(head);
    }
}
