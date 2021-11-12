package com.luxoft.datastructures.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest extends AbstractListTest {
    @Override
    protected List getList() {
        return new LinkedList();
    }

}
