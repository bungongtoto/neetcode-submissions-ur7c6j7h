class Node {
    int val;
    int key;
    Node next ;
    Node prev ;

    public Node (int val, int key){
        this.val = val;
        this.key = key;
        this.next = null;
        this.prev = null;
    }

}

class LRUCache {
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.head = null;
        this.tail = null;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (this.cache.containsKey(key)){
            Node node = this.cache.get(key);

            removeNode(node);
            addNode(node);
            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        // Update existing key
        if (this.cache.containsKey(key)) {
            Node node = this.cache.get(key);
            node.val = value;

            removeNode(node);
            addNode(node);
            return;
        }

       // Remove least recently used node
        if (this.cache.size() >= this.capacity) {
            removeHead();
        }

        Node node = new Node(value, key);

        this.cache.put(key, node);
        addNode(node);
    }

    private void removeHead(){
        if (this.head == null) return;

        Node temp = this.head;

        this.cache.remove(temp.key);
        removeNode(temp);
    }

    private void removeNode(Node node){
        if (node.prev != null){
            node.prev.next = node.next;
        }else {
            this.head = node.next;
        }

        if (node.next != null){
            node.next.prev = node.prev;
        }else {
            this.tail = node.prev;
        }

        node.prev = null;
        node.next = null;
       
    }

    private void addNode(Node node){

        node.next = null;
        node.prev = this.tail;

        if (this.head == null){
            this.head = node;
        }else {
            this.tail.next = node;
        }

        this.tail = node;
       
    }
}
