package com.luxoft.datastructures.list;

import com.luxoft.datastructures.list.List;

import java.util.Objects;

public class ArrayList implements List {
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
        ensureCapacity();
        array[size] = value;
        size++;
    }

    @Override
    public void add(Object value, int index) {
        ensureCapacity();
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException("Index out of List");
        }
        Object[] cloneArray = new Object[array.length];
        for (int i = 0; i<cloneArray.length; i++){
            cloneArray[i] = array[i];
        }
        array[index]=value;
        for (int i = index+1; i<array.length; i++){
            array[i] = cloneArray[i-1];
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        if (index > size-1 || index < 0){
            throw new IndexOutOfBoundsException("Index out of List");
        }
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
        if (index > size-1 || index < 0){
            throw new IndexOutOfBoundsException("Index out of List");
        }
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        if (index > size-1 || index < 0){
            throw new IndexOutOfBoundsException("Index out of List");
        }
        Object oldValue = array[index];
        array[index]= value;
        return oldValue;
    }

    @Override
    public void clear() {
        for(int i=0; i < array.length; i++){
            array[i]=null;
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
        if (isEmpty() ) {
            throw new IllegalStateException("List is empty!");
        }

        for(int i = 0; i < size-1 ; i++) {
            if(Objects.equals(value,array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        if (isEmpty() ) {
            throw new IllegalStateException("List is empty!");
        }
        for(int i = size-1; i >= 0; i --) {
            if(Objects.equals(value,array[i])) {
                return i;
            }
        }
        return -1;
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

    private void ensureCapacity() {
        if (array.length == size) {
            Object[] newArray = new Object[(int) (array.length * 1.5)];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }
}
