package com.luxoft.datastructures.list;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private int size;
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
        T[] cloneArray = (T[]) new Object[array.length];
        while (iterator.hasNext()) {
            cloneArray[count++] = (T) iterator.next();
        }
        array[index] = value;
        if (array.length - (index + 1) >= 0)
            System.arraycopy(cloneArray, index, array, index + 1, array.length - (index + 1));
        size++;
    }

    @Override
    public T remove(int index) {
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
        return array[index];
    }

    @Override
    public T set(T value, int index) {
        T oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    @Override
    public void clear() {
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
        for (int i = 0; i < size - 1; i++) {
            if (Objects.equals(value, array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(value, array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        Iterator<T> iterator = iterator();
        StringJoiner result = new StringJoiner(", ", "[", "]");
        while (iterator.hasNext()) {
            result.add(iterator.next() + "");
        }
        return result.toString();
    }

    private void ensureCapacity() {
        if (array.length == size) {
            T[] newArray = (T[]) new Object[(int) (array.length * 1.5)];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }


    private class ArrayListIterator implements Iterator<T> {
        private int index = 0;
        boolean canRemove;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            T value = array[index];
            index++;
            canRemove = true;
            return value;
        }

        @Override
        public void remove() {
            if (canRemove) {
                ArrayList.this.remove(index - 1);
            } else {
                throw new IllegalStateException("Already removed!");
            }
            canRemove = false;
            index--;
        }
    }
}
