package com.luxoft.datastructures.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractMapTest {
    private Map<String, Integer> testMap;

    @BeforeEach
    public void before() {
        testMap = getMap();
    }

    protected abstract Map<String, Integer> getMap();

    @Test
    void testPutAndGetWorkCorrect() {
        testMap.put("A", 1);
        testMap.put("B", 11);
        testMap.put("C", 1);

        assertEquals(3, testMap.size());
        assertEquals(1, testMap.get("A"));
        assertEquals(11, testMap.get("B"));
        assertEquals(1, testMap.get("C"));
    }


    @Test
    void testPutAndRemoveWorkCorrectAndMapIsEmptyAfterRemove() {
        testMap.put("A", 1);
        testMap.put("B", 11);
        testMap.put("C", 1);

        assertEquals(1, testMap.remove("A"));
        assertEquals(11, testMap.remove("B"));
        assertEquals(1, testMap.remove("C"));
        assertTrue(testMap.isEmpty());
    }

    @Test
    void isEmptyReturnTrueOnNewMap() {
        assertTrue(testMap.isEmpty());
    }

    @Test
    void testPutOverridesPreviousValue() {
        testMap.put("A", 1);
        testMap.put("B", 11);
        testMap.put("C", 1);

        assertEquals(3, testMap.size());
        assertEquals(1, testMap.get("A"));
        assertEquals(11, testMap.get("B"));
        assertEquals(1, testMap.get("C"));

        testMap.put("B", 10000);
        assertEquals(10000, testMap.get("B"));
    }

    @Test
    void testContainsKeyWorkCorrect() {
        testMap.put("A", 1);
        testMap.put("B", 11);

        assertTrue(testMap.containsKey("A"));
        assertTrue(testMap.containsKey("B"));
        assertFalse(testMap.containsKey("C"));
    }
}
