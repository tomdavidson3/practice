package com.prinkipia.examples;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class LruCache<K, V> implements Cache<K, V> {
    private LinkedHashMap<K, V> cache;

    private int size;

    public LruCache(int size) {
        this.size = size;
        cache = new LinkedHashMap<>(size, 0.75f, true);
    }

    public V put(K key, V value) {
        if (cache.size() >= size) {
            cache.remove(key);
        }

        return cache.put(key, value);
    }

    public V get(K key) {
        return cache.get(key);
    }

    public static void main(String[] args) {
        Cache<Integer, Integer> cache = new LruCache<>(3);

        for (int i=0; i < 4; i++) {
            cache.put(i, i);
        }

        System.out.println(cache);
    }
}
