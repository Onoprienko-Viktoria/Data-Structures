package com.luxoft.datastructures.list;

import java.util.Iterator;
import java.util.Objects;
import java.util.Random;

public class LinkedList implements List, Iterable {
    private Node head;
    private Node tail;
    private int size;

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        checkIndexOutOfBoundsWithSize(index, size);

        Node newNode = new Node(value);
        if (size == 0) {
            head = tail = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else if (index == 0) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            Node prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        checkIndexOutOfBoundsWithSizeMinusOne(index, size);
        checkIsEmptyThenThrowException();
        Node currentNode = head;
        Node nextNode = head.next;
        Node prevNode = null;

        while (currentNode != null) {
            if (index == 0) {
                if (prevNode == null) {
                    head = nextNode;
                    size--;
                    return currentNode.value;
                }
                prevNode.next = nextNode;
                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }
                size--;
                return currentNode.value;
            }
            if (index == size-1) {
                tail = tail.prev;
            }
            if (size == 1) {
                head = tail = null;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
            nextNode = currentNode.next;
            index--;
        }
        size--;
        return null;
    }


    private Node getNode(int index) {
        checkIndexOutOfBoundsWithSizeMinusOne(index, size);

        Node current = head;
        Node currentFromTail = tail;
        if (index <= size / 2) {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        } else {
            for (int i = size-1; i > index; i--) {
                currentFromTail = currentFromTail.prev;

            }
            return currentFromTail;
        }
    }

    @Override
    public Object get(int index) {
        checkIndexOutOfBoundsWithSize(index,size);

        return getNode(index).value;
    }

    @Override
    public Object set(Object value, int index) {
        checkIndexOutOfBoundsWithSize(index,size);

        Node newNode =getNode(index);
        Node oldNode = newNode;
        newNode.value = value;
        return oldNode.value;
    }

    @Override
    public void clear() {
        head=tail=null;
        size=0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }



    @Override
    public int indexOf(Object value) {
        checkIsEmptyThenThrowException();
        Node current = head;
        for (int i = 0; i < size-1; i++) {
            if(Objects.equals(current.value, value)){
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        checkIsEmptyThenThrowException();
        Node current = tail;
        for (int i = size-1; i >=0; i++) {
            if(Objects.equals(current.value, value)){
                return i;
            }
            if(current==head){
                break;
            }
            current = current.prev;
        }
        return -1;
    }

    @Override
    public String toString() {
        Iterator iterator = iterator();
        StringBuilder result = new StringBuilder();
        result.append("[");
        while (iterator.hasNext()){
            result.append(iterator.next() + ", ");
        }
        result.append("]");

        return result.toString();
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator {
        private int index=0;
        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Object next() {
            Node current = getNode(index);
            Object value = current.value;
            index++;
            return value;
        }
    }

    private class Node {
        Node next;
        Node prev;
        Object value;

        public Node(Object value) {
            this.value = value;
        }
    }

}
