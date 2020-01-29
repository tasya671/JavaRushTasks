package com.javarush.task.task09.task0902;

/* 
И снова StackTrace
*/

public class Solution {
    public static void main(String[] args) {
       method1();
    }

    public static String method1() {
        StackTraceElement [] stackTraceElement = Thread.currentThread().getStackTrace();
        String name = stackTraceElement[2].getMethodName();
        method2();
        //напишите тут ваш код
        return name;
    }

    public static String method2() {
        StackTraceElement [] stackTraceElement = Thread.currentThread().getStackTrace();
        String name = stackTraceElement[2].getMethodName();
        method3();
        //напишите тут ваш код
        return name;
    }

    public static String method3() {
        StackTraceElement [] stackTraceElement = Thread.currentThread().getStackTrace();
        String name = stackTraceElement[2].getMethodName();
        method4();
        //напишите тут ваш код
        return name;
    }

    public static String method4() {
        StackTraceElement [] stackTraceElement = Thread.currentThread().getStackTrace();
        String name = stackTraceElement[2].getMethodName();
        method5();
        return name;
        //напишите тут ваш код
    }

    public static String method5() {
        StackTraceElement [] stackTraceElement = Thread.currentThread().getStackTrace();
        String name = stackTraceElement[2].getMethodName();
        return name;
    }
}
