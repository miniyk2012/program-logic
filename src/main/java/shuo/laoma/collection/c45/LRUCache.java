package shuo.laoma.collection.c45;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int cap;

    public LRUCache(int cap) {
        super(16, 0.75f, true);
        this.cap = cap;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > this.cap;
    }

    public static void main(String[] args) {
        LRUCache<String, Object> cache = new LRUCache<>(3);
        cache.put("a", "abstract");
        cache.put("b", "basic");
        cache.put("c", "call");
        cache.get("a");
        cache.put("d", "dell");

        System.out.println(cache);
    }
}
