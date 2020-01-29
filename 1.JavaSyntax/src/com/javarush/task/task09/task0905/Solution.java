package com.javarush.task.task09.task0905;

/* 
Там, в синих глубинах стек-трейса…
*/

public class Solution {
    public static void main(String[] args) {
        int deep = getStackTraceDeep();
    }

    public static int getStackTraceDeep() {
        //напишите тут ваш код
        StackTraceElement [] stackTraceElements = Thread.currentThread().getStackTrace();
        int count = stackTraceElements.length;
        System.out.println(count);
        return count;
    }
}

