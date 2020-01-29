package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<Throwable> list = new ArrayList<>();
        list.add(e);
        Throwable l = e;
        while ((l.getCause())!=null){
            l =l.getCause();
            list.add(l);
        }
        for (int i = list.size()-1; i >=0 ; i--) {
            System.out.println(list.get(i));
        }

    }

    public static void main(String[] args) {
        new Solution().uncaughtException(Thread.currentThread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
