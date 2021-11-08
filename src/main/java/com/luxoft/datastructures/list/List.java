package com.luxoft.datastructures.list;

public interface List {
    void add(Object value);

    void add(Object value, int index);

    Object remove(int index);

    Object get(int index);

    Object set(Object value, int index);

    void clear();

    int size();

    boolean isEmpty();

    default boolean contains(Object value){
        return indexOf(value)>=0;
    }

    int indexOf(Object value);

    int lastIndexOf(Object value);

    String toString();
}
