package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.util.Date;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object object = new Date();
        Integer i = (int) object;
    }

    public void methodThrowsNullPointerException() {
        String str = null;
        str.trim();
    }

    public static void main(String[] args) {
    }
}
