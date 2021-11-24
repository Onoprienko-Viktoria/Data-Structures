package com.luxoft.datastructures.list;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;


public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void add(T value) {
        add(value, size);
    }

    @Override
    public void add(T value, int index) {
        validateIndexExistForMethodAdd(index, size);

        Node<T> newNode = new Node<>(value);
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
            Node<T> current = getNode(index);
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        validateIndexExist(index, size);

        Node<T> removedValue = getNode(index);
        Node<T> currentNode = removedValue;
        Node<T> nextNode = removedValue.next;
        Node<T> prevNode = removedValue.prev;

        if (index == 0) {
            head = nextNode;
        } else if (index == size - 1) {
            tail = tail.prev;
            prevNode.next = null;
        } else if (size == 1) {
            head = tail = null;
        } else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        size--;
        return removedValue.value;
    }

    public T remove(Node<T> removedValue) {

        Node<T> currentNode = removedValue;
        Node<T> nextNode = removedValue.next;
        Node<T> prevNode = removedValue.prev;

        if (Objects.equals(currentNode, head)) {
            head = nextNode;
        } else if (Objects.equals(currentNode.next, null) && Objects.equals(currentNode.prev, null)) {
            head = tail = null;
        } else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        size--;
        return removedValue.value;
    }

    private Node<T> getNode(int index) {
        validateIndexExist(index, size);

        if (index <= size / 2) {
            Node<T> currentFromHead = head;
            for (int i = 0; i < index; i++) {
                currentFromHead = currentFromHead.next;
            }
            return currentFromHead;
        } else {
            Node<T> currentFromTail = tail;
            for (int i = size - 1; i > index; i--) {
                currentFromTail = currentFromTail.prev;

            }
            return currentFromTail;
        }
    }

    @Override
    public T get(int index) {
        validateIndexExist(index, size);

        return getNode(index).value;
    }

    @Override
    public T set(T value, int index) {
        validateIndexExist(index, size);

        Node<T> newNode = getNode(index);
        Object oldValue = newNode.value;
        newNode.value = value;
        return (T) oldValue;
    }

    @Override
    public void clear() {
        head = tail = null;
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

        Node<T> current = head;
        for (int i = 0; i < size - 1; i++) {
            if (Objects.equals(current.value, value)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {

        Node<T> current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(current.value, value)) {
                return i;
            }
            current = current.prev;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ", "[", "]");
        for (T value : this) {
            result.add(String.valueOf(value));
        }
        return result.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    public class LinkedListIterator implements Iterator<T> {
        private Node<T> current = head;
        private int index = 0;
        private boolean canRemove;

        @Override
        public boolean hasNext() {
            return (index < size);
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            canRemove = true;
            index++;
            return value;
        }

        @Override
        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException("Already removed!");
            }
            if (current == null) {
                tail = tail.prev;
                size--;
                canRemove = false;
            } else {
                LinkedList.this.remove(current.prev);
                canRemove = false;
            }
            index--;
        }
    }


    private static class Node<T> {
        Node<T> next;
        Node<T> prev;
        T value;

        public Node(T value) {
            this.value = value;
        }
    }
}
