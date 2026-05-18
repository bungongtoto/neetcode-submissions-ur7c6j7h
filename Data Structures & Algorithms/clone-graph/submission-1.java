/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if (node == null)
        return node;

        Map<Node, Node> cNodes = new HashMap<>();

        Queue<Node> q = new LinkedList<>();

        cNodes.put(node , new Node(node.val));

        q.add(node);



        while (!q.isEmpty()){
            Node cN = q.poll();
            for (Node n : cN.neighbors){
                
                if(!cNodes.containsKey(n)){
                    cNodes.put(n, new Node(n.val));
                    q.add(n);
                }

                cNodes.get(cN).neighbors.add(cNodes.get(n));
            }
        }

        return cNodes.get(node);
        
    }
}