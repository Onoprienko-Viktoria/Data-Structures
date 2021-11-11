package com.luxoft.datastructures.list;

import java.util.Iterator;

public interface List {
    void add(Object value);

    void add(Object value, int index);

    Object remove(int index);

    Object get(int index);

    Object set(Object value, int index);

    void clear();

    int size();

    boolean isEmpty();

    default boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    int indexOf(Object value);

    int lastIndexOf(Object value);

    default void checkIndexOutOfBoundsWithSizeMinusOne(int index, int size) {

        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index out of List");
        }
    }

    default void checkIndexOutOfBoundsWithSize(int index, int size) {

        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of List");
        }
    }

    default void checkIsEmptyThenThrowException() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
    }

    String toString();
}


