package com.luxoft.datastructures.junit;

import com.luxoft.datastructures.list.AbstractListTest;
import com.luxoft.datastructures.list.ArrayList;
import com.luxoft.datastructures.list.ArrayListTest;
import com.luxoft.datastructures.queue.ArrayQueueTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class JUnit {
    public static void main(String[] args) throws Exception{
        System.out.println("\u001B[33m Test ArrayQueue: \u001B[0m");
        runTests(ArrayQueueTest.class);

    }

    static void runTests(Class clazz) throws Exception{
        Constructor constructor = clazz.getConstructor();

        Object testInstance = constructor.newInstance();

        ArrayList testMethods = getTests(clazz);

        for (int i = 0; i < testMethods.size(); i++) {
            Method testMethod = (Method) testMethods.get(i);
            System.out.println("Running test: " + testMethod.getName());
            try {
                testMethod.invoke(testInstance);
                // "\u001B[34m" - синий, "\u001B[32m" - зеленый, "\u001B[31m" - красный
                System.out.println("Test:" + "\u001B[34m" + testMethod.getName() + "\u001B[32m" +"  success" + "\u001B[0m");
            } catch (Throwable error){
                System.out.println("Test:" + "\u001B[31m" + testMethod.getName()  + "\u001B[31m" + "  failed" + "\u001B[0m");
            }

        }
    }

    private static ArrayList getTests(Class clazz) {
        ArrayList methodsList = new ArrayList();
        for (Method method : clazz.getMethods()) {
            if(method.isAnnotationPresent(Test.class)){
                methodsList.add(method);
            }
        }
        return methodsList;
    }
}
