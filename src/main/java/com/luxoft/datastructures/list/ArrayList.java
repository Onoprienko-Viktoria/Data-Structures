package com.luxoft.datastructures.list;

import com.luxoft.datastructures.list.List;

import java.util.Iterator;
import java.util.Objects;

public class ArrayList implements List, Iterable {
    private static  final int DEFAULT_INITIAL_CAPACITY = 10;
    private int size;
    private int index = 0;
    private Object[] array;

    public ArrayList() {
        this (DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        array = new Object[initialCapacity];
    }


    @Override
    public void add(Object value) {
        add(value,size);
    }

    @Override
    public void add(Object value, int index) {
        Iterator iterator = iterator();
        int count = 0;
        ensureCapacity();
        checkIndexOutOfBoundsWithSize(index,size);
        Object[] cloneArray = new Object[array.length];
        while (iterator.hasNext()){
            cloneArray[count++] = iterator.next();
        }
        array[index]=value;
        for (int i = index+1; i<array.length; i++){
            array[i] = cloneArray[i-1];
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        checkIndexOutOfBoundsWithSizeMinusOne(index,size);
        Object deletedValue = array[index];
        for (int i = index; i < size-1; i++) {
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
    public Object get(int index) {
        checkIndexOutOfBoundsWithSizeMinusOne(index,size);
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        checkIndexOutOfBoundsWithSizeMinusOne(index,size);
        Object oldValue = array[index];
        array[index]= value;
        return oldValue;
    }

    @Override
    public void clear() {
        for (Object arrayObject : array) {
            arrayObject=null;
        }
        size=0;

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
    public int indexOf(Object value) {
        checkIsEmptyThenThrowException();

        for(int i = 0; i < size-1 ; i++) {
            if(Objects.equals(value,array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        checkIsEmptyThenThrowException();

        for(int i = size-1; i >= 0; i --) {
            if(Objects.equals(value,array[i])) {
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
        while (iterator.hasNext()){
            result.append(iterator.next());
            result.append(", ");
        }
        result.append("]");

        return result.toString();
    }

    private void ensureCapacity() {
        if (array.length == size) {
            Object[] newArray = new Object[(int) (array.length * 1.5)];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }


    private class ArrayListIterator implements Iterator {
        private int index=0;
        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Object next() {
            Object value = array[index];
            index++;
            return value;
        }
    }

}
