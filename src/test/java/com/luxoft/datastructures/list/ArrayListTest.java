package com.luxoft.datastructures.list;

import com.luxoft.datastructures.list.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest extends AbstractListTest{
    @Override
    protected List getList() {
        return new ArrayList();
    }
}