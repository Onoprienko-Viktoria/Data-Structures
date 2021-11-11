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
}