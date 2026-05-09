class TimeMap {

    private Map<String , List<Pair<Integer, String>>> keyStore;

    public TimeMap() {
        this.keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = keyStore.getOrDefault(key, new ArrayList<>());

        int left = 0, right = values.size() - 1;
        String result = "";

        while (left <= right){
            int mid = (left + right) / 2;

            if (values.get(mid).getTimestamp() <= timestamp){
                result = values.get(mid).getValue();
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return result;

    }
}


private class Pair<T, V> {
    private T timestamp;
    private V value;

    public Pair (T timestamp, V value){
        this.timestamp = timestamp;
        this.value = value;
    }

    public T getTimestamp(){
        return this.timestamp;
    }

    public V getValue(){
        return this.value;
    }
}
