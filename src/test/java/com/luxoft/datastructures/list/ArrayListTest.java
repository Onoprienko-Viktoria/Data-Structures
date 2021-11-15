package com.luxoft.datastructures.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest extends AbstractListTest {
    @Override
    protected List<Object> getList() {
        return new ArrayList<>();
    }

    @Test
    public void testEnsureCapacity() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        assertEquals(12, arrayList.size());
    }

    @Test
    public void testPushOverInitialCapacityAndRemoveWorkCorrectlyAndChangeSize() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        arrayList.add(4);
        arrayList.add(3);

        assertEquals(3, arrayList.size());
        assertEquals(3, arrayList.remove(2));
        assertEquals(4, arrayList.remove(1));
        assertEquals(5, arrayList.remove(0));

        assertEquals(0, arrayList.size());
        assertTrue(arrayList.isEmpty());
    }

}