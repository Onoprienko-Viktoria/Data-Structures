package com.luxoft.datastructures.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {
    @Test
    public void TestDequeueAndEnqueueAndChangeSize(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");

        assertEquals(3, arrayQueue.size());
        assertEquals("A", arrayQueue.dequeue());
        assertEquals("B", arrayQueue.dequeue());
        assertEquals(1, arrayQueue.size());
        assertFalse(arrayQueue.isEmpty());
    }
    @Test
    public void TestDequeueAndPeek(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");

        assertEquals(3, arrayQueue.size());
        assertEquals("A", arrayQueue.peek());
        assertEquals("A", arrayQueue.peek());
        assertEquals(3, arrayQueue.size());
    }
    @Test
    public void testIsEmptyReturnTrueOnNewQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();

        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseOnQueueWithData() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("O");
        assertFalse(arrayQueue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnQueueAfterClear() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("O");
        arrayQueue.enqueue("B");
        arrayQueue.clear();
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testContainsReturnTrue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("O");
        arrayQueue.enqueue("B");

        assertTrue(arrayQueue.contains("O"));
    }
    @Test
    public void testContainsReturnFalse() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("O");
        arrayQueue.enqueue("B");

        assertFalse(arrayQueue.contains("X"));
    }

    @Test
    public void testContainsReturnFalseOnEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();

        assertFalse(arrayQueue.contains("C"));
    }




    @Test
    public void testString(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("O");
        arrayQueue.enqueue("B");
        String received = arrayQueue.toString();

        assertEquals("[B, O, B, ]", received);
    }

}
