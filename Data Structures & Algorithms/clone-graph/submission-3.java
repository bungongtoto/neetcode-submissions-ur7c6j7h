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
        if (node == null) return null;

        Map<Node, Node> m = new HashMap<>();

        Queue<Node> q = new ArrayDeque();

        q.offer(node);

        while (!q.isEmpty()){
            Node cur = q.poll();

            if (!m.containsKey(cur)){
                m.put(cur, new Node(cur.val));
            }

            for (Node n : cur.neighbors){
                if (!m.containsKey(n)){
                    m.put(n, new Node(n.val));
                    q.add(n);
                }

                m.get(cur).neighbors.add(m.get(n));
                
            }
        }

        return m.get(node);
        
    }
}