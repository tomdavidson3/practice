package com.prinkipia.examples;

import java.util.HashMap;
import java.util.Map;

public class LruCacheDoublyLinkedList<K, V> implements Cache<K, V> {
    private static class Node<K, V> {
        Node<K, V> previous;
        Node<K, V> next;

        V value;
        K key;
    }

    private Map<K, Node<K, V>> cache;
    private final int size;
    private Node<K, V> head;
    private Node<K, V> tail;

    public LruCacheDoublyLinkedList(final int size) {
        this.size = size;
        cache = new HashMap<>();
        head = new Node<>();
        tail = head;
    }

    public V get(final K key) {
        if (cache.containsKey(key)) {
            Node<K, V> n = cache.get(key);
            put(key, n.value);
            return n.value;
        }
        else {
            return null;
        }
    }

    @Override
    public V put(final K key, final V value) {
        Node<K, V> n = new Node<>();
        n.value = value;
        n.key = key;
        if (cache.size() >= size) {
            delete(tail);
            cache.remove(tail.key);
        }

        insert(n);

        cache.put(key, n);

        return value;
    }

    private void insert(Node<K, V> n) {
        // insert new node at head
        n.next = head;
        if (head != null) {
            head.previous = n;
        }
        head = n;
        n.previous = null;
    }

    private void delete(Node<K, V> n) {
        if (n.previous != null) {
            n.previous.next = n.next;
        }
        else {
            head = n.next;
        }
        if (n.next != null) {
            n.next.previous = n.previous;
        }
        else {
            tail = n.previous;
        }
    }

    public static void main(String[] args) {
        Cache<String, String> cache = new LruCacheDoublyLinkedList<>(4);

        cache.put("one", "one");
        cache.put("two", "two");
        cache.put("three", "three");
        cache.put("four", "four");
        cache.put("five", "five");
        System.out.println(cache.get("one"));
    }
}
