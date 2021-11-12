package com.luxoft.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractListTest {
    private List arrayList;

    @BeforeEach
    public void  before(){
        arrayList = getList();
    }

    protected abstract List getList();


    @Test
    public void testAddAndRemoveByLastIndexAndGetWorkCorrectly(){

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D",2);
        assertEquals(4, arrayList.size());
        assertEquals("A", arrayList.get(0));
        assertEquals("B", arrayList.get(1));
        assertEquals("C", arrayList.get(3));
        assertEquals("D", arrayList.get(2));
        assertEquals("C", arrayList.remove(3));
        assertEquals("D", arrayList.get(2));
        assertEquals(3, arrayList.size());
    }

    @Test
    public void testAddAndRemoveByZeroIndexAndGetWorkCorrectly(){

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D",0);
        assertEquals(4, arrayList.size());
        assertEquals("D", arrayList.get(0));
        assertEquals("A", arrayList.get(1));
        assertEquals("C", arrayList.get(3));
        assertEquals("B", arrayList.get(2));
        assertEquals("D", arrayList.remove(0));
        assertEquals("A", arrayList.get(0));
        assertEquals(3, arrayList.size());
    }

    @Test
    public void testAddAndRemoveByMiddleIndexAndGetWorkCorrectly(){

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D",1);
        assertEquals(4, arrayList.size());
        assertEquals("A", arrayList.get(0));
        assertEquals("D", arrayList.get(1));
        assertEquals("C", arrayList.get(3));
        assertEquals("B", arrayList.get(2));
        assertEquals("D", arrayList.remove(1));
        assertEquals("B", arrayList.get(1));
        assertEquals(3, arrayList.size());
    }

    @Test
    public void testIsEmptyReturnTrueOnNewList() {
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseOnListWithData() {
        arrayList.add("O");
        assertFalse(arrayList.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnListAfterClear() {
        
        arrayList.add("O");
        arrayList.add("I");
        arrayList.add("O");
        arrayList.clear();
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testContainsReturnTrue() {
        
        arrayList.add("T");
        arrayList.add("O");
        arrayList.add("R");

        assertTrue(arrayList.contains("O"));
    }

    @Test
    public void testContainsReturnFalse() {
        
        arrayList.add("T");
        arrayList.add("O");
        arrayList.add("R");

        assertFalse(arrayList.contains("p"));
    }

    @Test
    public void testContainsNull() {

        arrayList.add("A");
        arrayList.add(null);
        arrayList.add("A");

        assertTrue(arrayList.contains(null));
        arrayList.set("D", 1);
        assertFalse(arrayList.contains(null));
    }


    @Test
    public void testLastIndexOfAndIndexOfWorkCorrectly() {
        
        arrayList.add("T");
        arrayList.add("O");
        arrayList.add("R");
        arrayList.add("O");

        assertEquals(1, arrayList.indexOf("O"));
        assertEquals(3, arrayList.lastIndexOf("O"));
    }

    @Test
    public void testLastIndexOfAndIndexOfNullWorkCorrectly() {

        arrayList.add("T");
        arrayList.add(null);
        arrayList.add("R");
        arrayList.add(null);

        assertEquals(1, arrayList.indexOf(null));
        assertEquals(3, arrayList.lastIndexOf(null));
    }

    @Test
    public void testLastIndexOfAndIndexOfReturnsMinusOne() {

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        assertEquals(-1, arrayList.indexOf("T"));
        assertEquals(-1, arrayList.lastIndexOf("T"));
    }

    @Test
    public void testGetAndSetWorkCorrectly() {
        
        arrayList.add("T");
        arrayList.add("O");
        arrayList.add("R");
        arrayList.add("O");

        assertEquals("O", arrayList.get(1));
        arrayList.set("H", 1);
        assertEquals("H", arrayList.get(1));
    }

    @Test
    public void testGetAndSetWorkWithNullCorrectly() {

        arrayList.add("T");
        arrayList.add(null);
        arrayList.add("R");
        arrayList.add("O");

        assertEquals(null, arrayList.get(1));
        arrayList.set(null, 2);
        assertEquals(null, arrayList.get(2));
    }



    @Test
    public void testPushOverInitialCapacityAndRemoveWorkCorrectlyAndChangeSize() {
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals(3, arrayList.size());
        assertEquals("C", arrayList.remove(2));
        assertEquals("B", arrayList.remove(1));
        assertEquals("A", arrayList.remove(0));

        assertEquals(0, arrayList.size());
        assertTrue(arrayList.isEmpty());
    }



    @Test
    public void testIndexOutOfBoundsExceptionOnGetAndSetAndAddAndRemove() {
        
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.get(3);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.set("S", -2);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("S", 4);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(-1);
        });
    }

    @Test
    public void testIllegalStateExceptionOnLastIndexOfAndIndexOf() {

        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayList.indexOf(0);
        });
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayList.lastIndexOf(0);
        });
    }




    @Test
    public void testToString() {
        
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        String received = arrayList.toString();

        assertEquals("[A, A, A, ]", received);
    }




}
