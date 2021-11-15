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
        checkIndexOutOfBoundsWithSize(index, size);

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
            Node<T> prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        checkIndexOutOfBoundsWithSizeMinusOne(index, size);
        checkIsEmptyThenThrowException();
        Node<T> currentNode = head;
        Node<T> nextNode = head.next;
        Node<T> prevNode = null;

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
            if (index == size - 1) {
                Node<T> deleted = getNode(size - 1);
                prevNode = getNode(size - 2);
                prevNode.next = null;
                tail = prevNode;
                size--;
                return deleted.value;
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


    private Node<T> getNode(int index) {
        checkIndexOutOfBoundsWithSizeMinusOne(index, size);

        Node<T> currentFromHead = head;
        Node<T> currentFromTail = tail;
        if (index <= size / 2) {
            for (int i = 0; i < index; i++) {
                currentFromHead = currentFromHead.next;
            }
            return currentFromHead;
        } else {
            for (int i = size - 1; i > index; i--) {
                currentFromTail = currentFromTail.prev;

            }
            return currentFromTail;
        }
    }

    @Override
    public T get(int index) {
        checkIndexOutOfBoundsWithSize(index, size);

        return getNode(index).value;
    }

    @Override
    public T set(T value, int index) {
        checkIndexOutOfBoundsWithSize(index, size);

        Node<T> newNode = getNode(index);
        newNode.value = value;
        return newNode.value;
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
        checkIsEmptyThenThrowException();
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
        checkIsEmptyThenThrowException();
        Node<T> current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(current.value, value)) {
                return i;
            }
            if (current == head) {
                break;
            }
            current = current.prev;
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

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    public class LinkedListIterator implements Iterator<T> {
        private int index = 0;
        private boolean canRemove;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            Node<T> current = getNode(index);
            T value = current.value;
            index++;
            canRemove = true;
            return value;
        }

        @Override
        public void remove() {
            if (canRemove) {
                LinkedList.this.remove(index - 1);
            } else {
                throw new IllegalStateException("Already removed!");
            }
            index--;
            canRemove = false;
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
