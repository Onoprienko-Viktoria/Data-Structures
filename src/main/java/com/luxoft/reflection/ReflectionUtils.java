package com.luxoft.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionUtils {
    //    Метод принимает класс и возвращает созданный объект этого класса
//    public static Object create(Class clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Constructor constructor = clazz.getConstructor();
//        Object result = constructor.newInstance();
//        return result;
//    }
//    //    Метод принимает object и вызывает у него все методы без параметров
//    public static void getMethodsWithoutParameters(Object object){
////        Class clazz =object.getClass();
////        Method[] methods = clazz.getDeclaredMethods();
////        for (Method method : methods) {
////            if (method.getParameterCount() == 0) {
////                if (!method.canAccess(object)) {
////                    method.trySetAccessible();
////                }
////                try {
////                    method.invoke(object);
////                } catch (IllegalAccessException | InvocationTargetException e) {
////                    e.printStackTrace();
////                }
////            }
////        }
//    }
//    //    Метод принимает object и выводит на экран все сигнатуры методов в который есть final
//    public static void printFinalMethodsSignatures(Object object){
//        Class clazz = object.getClass();
//        Method[] methods = clazz.getDeclaredMethods();
//        for (Method method : methods) {
//            if (Modifier.isFinal(method.getModifiers())) {
//                System.out.println(method);
//            }
//        }
//    }
//    //    Метод принимает Class и выводит все не публичные методы этого класса
//    public static void getNonPublicMethods(Class clazz){
//        Method[] methods = clazz.getDeclaredMethods();
//        for (Method method : methods) {
//            if (!Modifier.isPublic(method.getModifiers())) {
//                System.out.println(method.getName());
//            }
//        }
//
//    }
//    //    Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует
//    public static void getImplementedInterfacesAndParentClasses(Class clazz){
//
//    }
//    //    Метод принимает объект и меняет все его приватные поля на их нулевые значение (null, 0, false etc)+
//    public static void setPrivatFieldsOnZeroValue(Object object){
//
//    }
}
