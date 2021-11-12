package com.luxoft.datastructures.queue;

import java.util.Objects;

public class ArrayQueue implements Queue {
    private int size;
    private int index = 0;
    private Object[] array;

    public ArrayQueue() {
        array = new Object[10];
    }

    public ArrayQueue(int initialCapacity) {
        array = new Object[initialCapacity];
    }

    @Override
    public void enqueue(Object value) {
        ensureCapacity();
        array[size] = value;
        size++;
    }

    private void ensureCapacity() {
        if (array.length == size) {
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        Object result = array[index];
        size--;
        index++;
        return result;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        return array[0];
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
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(value, array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            result.append(", ");
        }
        result.append("]");

        return result.toString();
    }
}
