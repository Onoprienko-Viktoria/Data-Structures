package com.luxoft.datastructures.list;

import com.luxoft.datastructures.list.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest extends AbstractListTest {
    @Override
    protected List getList() {
        return new ArrayList();
    }

    @Test
    public void testEnsureCapacity() {
        ArrayList arrayList = new ArrayList();
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
        ArrayList arrayList = new ArrayList();
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

}