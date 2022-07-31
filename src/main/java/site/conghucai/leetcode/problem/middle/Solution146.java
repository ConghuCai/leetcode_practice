package site.conghucai.leetcode.problem.middle;

import java.util.LinkedHashMap;

public class Solution146 {

}

class LRUCache {
    private int capacity;
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);

            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
            return;
        }

        if (capacity == cache.size()) {
            int firstKey = cache.keySet().iterator().next();
            cache.remove(firstKey);
        }

        cache.put(key, value);
    }
}
