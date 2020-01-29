package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/
public class Solution extends Thread implements Thread.UncaughtExceptionHandler {

    public Solution() {
        super();
        setUncaughtExceptionHandler(this);
    }
    public void uncaughtException(Thread t, Throwable e) {
        if(e instanceof Error)
            System.out.println("Нельзя дальше работать");
        else if (e instanceof Exception)
            System.out.println("Надо обработать");
        else if (e instanceof Throwable)
            System.out.println("Поживем - увидим");
    }

    public static void main(String[] args) {
        //new Solution().uncaughtException(Thread.currentThread(),new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
        //new Solution().uncaughtException(Thread.currentThread(), new OutOfMemoryError());
    }
}
