package com.luxoft.datastructures.map;

class HashMapTest extends AbstractMapTest {

    @Override
    protected Map<String, Integer> getMap() {
        return new HashMap<>();
    }
}