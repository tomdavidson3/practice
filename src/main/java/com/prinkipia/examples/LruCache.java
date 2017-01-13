package com.prinkipia.examples;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class LruCache<K, V> implements Cache<K, V> {
    private Map<K, V> cache;
    private Queue<K> timestamps;

    private int size;

    public LruCache(int size) {
        this.size = size;
        cache = new TreeMap<>();
        timestamps = new LinkedList<>();
    }

    public V put(K key, V value) {
        if (cache.size() >= size) {
            evictLeastRecentlyUsed();
        }

        timestamps.add(key);

        return cache.put(key, value);
    }

    public V get(K key) {
        return cache.get(key);
    }

    private void evictLeastRecentlyUsed() {
        K key = timestamps.remove();
        timestamps.remove();
        cache.remove(key);
    }

    public static void main(String[] args) {
        Cache<Integer, Integer> cache = new LruCache<>(3);

        for (int i=0; i < 4; i++) {
            cache.put(i, i);
        }

        System.out.println(cache);
    }
}
