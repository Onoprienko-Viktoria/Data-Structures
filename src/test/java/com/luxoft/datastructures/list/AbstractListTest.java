package com.luxoft.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractListTest {
    private List<Object> list;

    @BeforeEach
    public void before() {
        list = getList();
    }

    protected abstract List<Object> getList();


    @Test
    public void testAddAndRemoveByLastIndexAndGetWorkCorrectly() {

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D", 2);
        assertEquals(4, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(3));
        assertEquals("D", list.get(2));
        assertEquals("C", list.remove(3));
        assertEquals("D", list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    public void testAddAndRemoveByZeroIndexAndGetWorkCorrectly() {

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D", 0);
        assertEquals(4, list.size());
        assertEquals("D", list.get(0));
        assertEquals("A", list.get(1));
        assertEquals("C", list.get(3));
        assertEquals("B", list.get(2));
        assertEquals("D", list.remove(0));
        assertEquals("A", list.get(0));
        assertEquals(3, list.size());
    }

    @Test
    public void testAddAndRemoveByMiddleIndexAndGetWorkCorrectly() {

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D", 1);
        assertEquals(4, list.size());
        assertEquals("A", list.get(0));
        assertEquals("D", list.get(1));
        assertEquals("C", list.get(3));
        assertEquals("B", list.get(2));
        assertEquals("D", list.remove(1));
        assertEquals("B", list.get(1));
        assertEquals(3, list.size());
    }

    @Test
    public void testIsEmptyReturnTrueOnNewList() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseOnListWithData() {
        list.add("O");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnListAfterClear() {

        list.add("O");
        list.add("I");
        list.add("O");
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testContainsReturnTrue() {

        list.add("T");
        list.add("O");
        list.add("R");

        assertTrue(list.contains("O"));
    }

    @Test
    public void testContainsReturnFalse() {

        list.add("T");
        list.add("O");
        list.add("R");

        assertFalse(list.contains("p"));
    }

    @Test
    public void testContainsNull() {

        list.add("A");
        list.add(null);
        list.add("A");

        assertTrue(list.contains(null));
        list.set("D", 1);
        assertFalse(list.contains(null));
    }


    @Test
    public void testLastIndexOfAndIndexOfWorkCorrectly() {

        list.add("T");
        list.add("O");
        list.add("R");
        list.add("O");

        assertEquals(1, list.indexOf("O"));
        assertEquals(3, list.lastIndexOf("O"));
    }

    @Test
    public void testLastIndexOfAndIndexOfNullWorkCorrectly() {

        list.add("T");
        list.add(null);
        list.add("R");
        list.add(null);

        assertEquals(1, list.indexOf(null));
        assertEquals(3, list.lastIndexOf(null));
    }

    @Test
    public void testLastIndexOfAndIndexOfReturnsMinusOne() {

        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals(-1, list.indexOf("T"));
        assertEquals(-1, list.lastIndexOf("T"));
    }

    @Test
    public void testGetAndSetWorkCorrectly() {

        list.add("T");
        list.add("O");
        list.add("R");
        list.add("O");

        assertEquals("O", list.get(1));
        list.set("H", 1);
        assertEquals("H", list.get(1));
    }

    @Test
    public void testGetAndSetWorkWithNullCorrectly() {

        list.add("T");
        list.add(null);
        list.add("R");
        list.add("O");

        assertNull(list.get(1));
        list.set(null, 2);
        assertNull(list.get(2));
    }

    @DisplayName("Test Iterator work correctly and throw Illegal State Exception if try call remove() twice for one element")
    @Test
    public void testIterator() {
        list.add("A");
        list.add("B");
        list.add("C");
        Iterator<Object> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        iterator.remove();
        assertEquals("C", iterator.next());
        iterator.remove();
        assertEquals(1, list.size());
        IllegalStateException exception = assertThrows(IllegalStateException.class, iterator::remove);
        Assertions.assertEquals("Already removed!", exception.getMessage());


    }

    @DisplayName("Test IndexOutOfBoundsException throws if try to call the 'Get', 'Set', 'Add' or 'Remove' methods with index over size or less than zero")
    @Test
    public void testIndexOutOfBoundsExceptionOn() {

        list.add("A");
        list.add("A");
        list.add("A");

        IndexOutOfBoundsException exceptionGet = assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
        Assertions.assertEquals("Index out of List", exceptionGet.getMessage());

        IndexOutOfBoundsException exceptionSet = assertThrows(IndexOutOfBoundsException.class, () -> list.set("S", -2));
        Assertions.assertEquals("Index out of List", exceptionSet.getMessage());

        IndexOutOfBoundsException exceptionAdd = assertThrows(IndexOutOfBoundsException.class, () -> list.add("S", 4));
        Assertions.assertEquals("Index out of List", exceptionAdd.getMessage());

        IndexOutOfBoundsException exceptionRemove = assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        Assertions.assertEquals("Index out of List", exceptionRemove.getMessage());
    }

    @DisplayName("Test IllegalStateException throws if try to call the 'Last index of' and 'Index of' methods on an empty list")
    @Test
    public void testIllegalStateException() {

        IllegalStateException exceptionIndexOf = assertThrows(IllegalStateException.class, () -> list.indexOf("A"));
        Assertions.assertEquals("List is empty!", exceptionIndexOf.getMessage());
        IllegalStateException exceptionLastIndexOf = assertThrows(IllegalStateException.class, () -> list.lastIndexOf("B"));
        Assertions.assertEquals("List is empty!", exceptionLastIndexOf.getMessage());
    }


    @Test
    public void testToString() {
        list.add("A");
        list.add("A");
        list.add("A");
        String received = list.toString();

        assertEquals("[A, A, A]", received);
    }

}
