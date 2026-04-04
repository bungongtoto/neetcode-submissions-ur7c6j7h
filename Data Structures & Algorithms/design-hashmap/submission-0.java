class MyHashMap {
    private int[] store;

    public MyHashMap() {
        this.store = new int[1000001];
        Arrays.fill(store, -1);
    }
    
    public void put(int key, int value) {
        this.store[key] = value;
    }
    
    public int get(int key) {
        return this.store[key];
    }
    
    public void remove(int key) {
        this.store[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */