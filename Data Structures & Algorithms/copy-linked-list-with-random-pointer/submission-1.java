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

        HashMap<Node, Node> oldCopy = new HashMap<>();
        oldCopy.put(null, null);
        Node curr = head;
        while (curr != null){
            
            //copy the main node
            if(!oldCopy.containsKey(curr)){
               oldCopy.put(curr, new Node(0));
            }

            oldCopy.get(curr).val = curr.val;
            //copy the next
            if(!oldCopy.containsKey(curr.next)){
                oldCopy.put(curr.next, new Node(0));
            }
            oldCopy.get(curr).next = oldCopy.get(curr.next);
            //copy the random
            if(!oldCopy.containsKey(curr.random)){
                oldCopy.put(curr.random, new Node(0));
            }
            oldCopy.get(curr).random = oldCopy.get(curr.random);
            curr = curr.next;
        }

        return oldCopy.get(head);
        
    }
}
