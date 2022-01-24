package com.luxoft.datastructures.map;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListMap<K, V> implements Map<K, V> {
    ArrayList<Entry<K, V>> entries = new ArrayList<>();
    private int size;


    @Override
    public V put(K key, V value) {
        Entry<K, V> entry = getEntry(key);
        if (entry != null) {
            V oldValue = entry.value;
            entry.value = value;
            return oldValue;
        }

        entries.add(new Entry<>(key, value));
        size++;
        return null;
    }

    @Override
    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        return entry == null ? null : entry.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V remove(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) {
            return null;
        }
        entries.remove(entry);
        size--;
        return entry.value;
    }

    @Override
    public boolean containsKey(K key) {
        Entry<K, V> entry = getEntry(key);
        return entry != null;
    }


    private Entry<K, V> getEntry(K key) {
        for (Entry<K, V> entry : entries) {
            if (Objects.equals(entry.key, key)) {
                return entry;
            }
        }
        return null;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
