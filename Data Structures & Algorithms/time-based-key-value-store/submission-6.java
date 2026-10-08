class TimeMap {

    private Map<String, List<Pair<Integer, String>>> store;

    public TimeMap() {
        this.store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair<Integer, String> pair = new Pair(timestamp, value); 
        this.store.computeIfAbsent(key, k -> new ArrayList<>()).add(pair);
    }
    
    public String get(String key, int timestamp) {
        
        List<Pair<Integer, String>> pairs = this.store.get(key);

        if (pairs == null) return "";

        int l = 0 , r = pairs.size() - 1;
        String res = "";

        while (l <= r){
            int mid = l + (r - l) / 2;

            if (pairs.get(mid).getTimestamp() <= timestamp){        
                res = pairs.get(mid).getValue();
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }

        return res;

       
    }
}

public class Pair<T, V>{
    private T timestamp;
    private V value;

    public Pair(T timestamp, V value){
        this.timestamp = timestamp;
        this.value = value;
    }

    public T getTimestamp(){
        return this.timestamp;
    }

    public V getValue (){
        return this.value;
    }
}
