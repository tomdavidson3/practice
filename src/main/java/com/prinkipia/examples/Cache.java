package com.prinkipia.examples;

public interface Cache<K,V> {
    // put an item in the cache
    V put(K key, V value);

    V get(K key);
}

