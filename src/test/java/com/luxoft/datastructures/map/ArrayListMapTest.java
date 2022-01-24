package com.luxoft.datastructures.map;

class ArrayListMapTest extends AbstractMapTest {

    @Override
    protected Map<String, Integer> getMap() {
        return new ArrayListMap<>();
    }
}