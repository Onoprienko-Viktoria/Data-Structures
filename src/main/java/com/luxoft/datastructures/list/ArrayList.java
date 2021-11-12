package com.luxoft.datastructures.list;

import java.util.Iterator;
import java.util.Objects;

public class ArrayList<T> implements List<T>, Iterable {
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private int size;
    private int index = 0;
    private T[] array;

    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        array = (T[]) new Object[initialCapacity];
    }


    @Override
    public void add(T value) {
        add(value, size);
    }

    @Override
    public void add(T value, int index) {
        Iterator iterator = iterator();
        int count = 0;
        ensureCapacity();
        checkIndexOutOfBoundsWithSize(index, size);
        T[] cloneArray = (T[]) new Object[array.length];
        while (iterator.hasNext()) {
            cloneArray[count++] = (T) iterator.next();
        }
        array[index] = value;
        for (int i = index + 1; i < array.length; i++) {
            array[i] = cloneArray[i - 1];
        }
        size++;
    }

    @Override
    public T remove(int index) {
        checkIndexOutOfBoundsWithSizeMinusOne(index, size);
        T deletedValue = array[index];
        for (int i = index; i < size - 1; i++) {
            if (i == (size - 1)) {
                array[i] = null;
            } else {
                array[i] = array[i + 1];
            }
        }

        size--;
        return deletedValue;

    }

    @Override
    public T get(int index) {
        checkIndexOutOfBoundsWithSizeMinusOne(index, size);
        return array[index];
    }

    @Override
    public T set(T value, int index) {
        checkIndexOutOfBoundsWithSizeMinusOne(index, size);
        T oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    @Override
    public void clear() {
        for (T arrayObject : array) {
            arrayObject = null;
        }
        size = 0;

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
    public int indexOf(T value) {
        checkIsEmptyThenThrowException();

        for (int i = 0; i < size - 1; i++) {
            if (Objects.equals(value, array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        checkIsEmptyThenThrowException();

        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(value, array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        Iterator iterator = iterator();
        StringBuilder result = new StringBuilder();
        result.append("[");
        while (iterator.hasNext()) {
            result.append(iterator.next());
            result.append(", ");
        }

        result.append("]");

        return result.toString();
    }

    private void ensureCapacity() {
        if (array.length == size) {
            T[] newArray = (T[]) new Object[(int) (array.length * 1.5)];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public Iterator iterator() {
        return new ListIterator();
    }


    private class ListIterator implements Iterator {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            T value = array[index];
            index++;
            return value;
        }
    }

}
