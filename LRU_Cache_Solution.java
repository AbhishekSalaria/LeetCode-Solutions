public class LRU_Cache_Solution {
    private int capacity;
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key,value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.remove(key);
        }
        else if (map.size() >= capacity) {
            Map.Entry<Integer,Integer> lruElement = map.entrySet().iterator().next();
            map.remove(lruElement.getKey());
        }
        map.put(key,value);
    }
}