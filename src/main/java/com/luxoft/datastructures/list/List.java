package com.luxoft.datastructures.list;

import java.util.Iterator;

public interface List<T> extends Iterable<T> {
    void add(T value);

    void add(T value, int index);

    T remove(int index);

    T get(int index);

    T set(T value, int index);

    void clear();

    int size();

    boolean isEmpty();

    default boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    int indexOf(T value);

    int lastIndexOf(T value);

    @Override
    Iterator<T> iterator();

    String toString();

    default void validateIndexExist(int index, int size) {

        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index out of List");
        }
    }

    default void validateIndexExistForMethodAdd(int index, int size) {

        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of List");
        }
    }
}


